package com.agalobr.movies.data

import com.agalobr.movies.data.local.MoviesLocalDataSource
import com.agalobr.movies.data.remote.MoviesRemoteDataSource
import com.agalobr.movies.domain.Movie
import com.agalobr.movies.domain.MoviesRepository

class MovieDataRepository(
    private val remoteDataSource: MoviesRemoteDataSource,
    private val localDataSource: MoviesLocalDataSource
) : MoviesRepository {

    override fun getMovies(): List<Movie> {
        var movies = localDataSource.getMovies()
        if (movies.isEmpty()) {
            movies = remoteDataSource.getAllMovies()
            if (movies.isNotEmpty()) {
                localDataSource.saveMovies(movies)
            }
        }
        return movies
    }

    override fun getMoviesById(Id: String): Movie? {
        var movie = localDataSource.getMovieById(Id)
        if (movie == null) {
            movie = remoteDataSource.getMovieById(Id)
        }
        return movie
    }
}