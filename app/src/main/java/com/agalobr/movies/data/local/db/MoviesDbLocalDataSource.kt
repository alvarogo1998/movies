package com.agalobr.movies.data.local.db

import com.agalobr.movies.data.local.MoviesLocalDataSource
import com.agalobr.movies.domain.Movie

class MoviesDbLocalDataSource(private val dao: MoviesDao) : MoviesLocalDataSource {

    override fun saveMovies(movie: List<Movie>) {
        movie.forEach { movie ->
            dao.saveMovies(movie.toEntity())
        }
    }

    override fun getMovies(): List<Movie> {
        return dao.getMovies().map {
            it.toDomain()
        }
    }

    override fun getMovieById(movieId: String): Movie? {
        return dao.getMovieById(movieId)?.toDomain()
    }
}