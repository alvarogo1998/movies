package com.agalobr.movies.data.remote.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    @GET("all.json")
    fun getAllMovies(): Call<List<MoviesApiModels>>

    @GET("id/{movieId}.json")
    fun getMovieById(@Path("movieId") heroId: String): Call<MoviesApiModels>
}