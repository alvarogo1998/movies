package com.agalobr.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.agalobr.movies.data.remote.retrofit.ApiClient
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    val apiClient = ApiClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread {
            val movies = apiClient.getAllMovies()
            Log.d("@dev", "Movies: $movies")
            val movie = apiClient.getMovieById("intestellar")
            Log.d("@dev", "Movie: $movie")
        }.start()
    }


}