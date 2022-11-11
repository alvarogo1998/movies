package com.agalobr.movies.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("/movies")
    fun getAllMovies(): Call<List<MoviesApiModels>>

    @GET("/movies/{movieId}")
    fun getMovieById(@Path("movieId") movieId: String): Call<MoviesApiModels>
}