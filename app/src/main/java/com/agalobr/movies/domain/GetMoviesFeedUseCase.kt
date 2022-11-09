package com.agalobr.movies.domain

class GetMoviesFeedUseCase(val repository: MoviesRepository) {
    fun execute(): List<MovieFeed> {
        val movie = repository.getMovies()

        val list = movie.map {
            MovieFeed(
                it.id,
                it.title,
                it.genre,
                it.rating,
                it.year,
                it.poster
            )
        }
        return list
    }

    data class MovieFeed(
        val id: String,
        val title: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}