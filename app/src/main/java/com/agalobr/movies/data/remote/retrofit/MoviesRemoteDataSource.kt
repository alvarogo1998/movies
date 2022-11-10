package com.agalobr.movies.data.remote.retrofit

import com.agalobr.movies.domain.Movie
import com.agalobr.movies.data.remote.MoviesRemoteDataSource

class MoviesRemoteDataSource(val apiClient: ApiClient) : MoviesRemoteDataSource {

    override fun getAllMovies(): List<Movie> {
        val movies = apiClient.getAllMovies()
        return movies.map {
            it.toDomain()
        }
    }

    override fun getMovieById(movieId: String): Movie? {
        return apiClient.getMovieById(movieId)?.toDomain()
    }
}