package com.agalobr.movies.domain

class GetMoveDetailUseCase(val repository: MoviesRepository) {

    fun execute(id: String): MovieDetail {
        val movie = repository.getMoviesById(id)!!

        return MovieDetail(
            movie.id,
            movie.title,
            movie.plot,
            movie.genre,
            movie.rating,
            movie.year,
            movie.poster
        )
    }

    data class MovieDetail(
        val id: String,
        val title: String,
        val plot: String,
        val genre: String,
        val rating: String,
        val year: String,
        val poster: String
    )
}