package com.agalobr.movies.domain

interface MoviesRepository {
    fun getMovies(): List<Movie>
    fun getMoviesById(id: String): Movie?
}