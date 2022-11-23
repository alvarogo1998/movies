package com.agalobr.movies.data.local.mem

import com.agalobr.app.data.local.mem.MemDataStore
import com.agalobr.movies.data.local.MoviesLocalDataSource
import com.agalobr.movies.domain.Movie

class MovieMemLocalDataSource(private val dataStore: MemDataStore<Movie>) :
    MoviesLocalDataSource {

    override fun saveMovies(movie: List<Movie>) {
        movie.forEach { saveMovie(it) }
    }

    private fun saveMovie(movie: Movie) {
        dataStore.put(movie.id, movie)
    }

    override fun getMovies(): List<Movie> = dataStore.getAll()

    override fun getMovieById(movieId: String): Movie? = dataStore.get(movieId)
}