package com.agalobr.movies.data.remote.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Retrofit
 **/

class ApiClient {

    private val baseEndPoint = "https://movies-and-shows-api.cyclic.app/"

    private val apiServices: ApiServices

    init {
        apiServices = buildApiEndPoint()
    }

    fun createRetrofitClient() = Retrofit.Builder()
        .baseUrl(baseEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun buildApiEndPoint() = createRetrofitClient().create(ApiServices::class.java)

    fun getAllMovies(): List<MoviesApiModels> {
        val call = apiServices.getAllMovies()
        val response = call.execute()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        }
        return emptyList()
    }

    fun getMovieById(movieId: String): MoviesApiModels? {
        val call = apiServices.getMovieById(movieId).execute()
        return call.body()
    }
}