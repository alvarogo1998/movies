package com.agalobr.movies.data.local

import com.agalobr.movies.domain.Movie

interface MoviesLocalDataSource {
    fun saveMovies(movie: List<Movie>)
    fun getMovies(): List<Movie>
    fun getMovieById(movieId: String): Movie?
}