package com.agalobr.movies.data.remote

import com.agalobr.movies.domain.Movie

interface MoviesRemoteDataSource {
    fun getAllMovies(): List<Movie>
    fun getMovieById(movieId: String): Movie?
}