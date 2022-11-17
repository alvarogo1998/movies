package com.agalobr.movies.data.local.xml

import android.content.SharedPreferences
import com.agalobr.movies.data.local.MoviesLocalDataSource
import com.agalobr.movies.domain.Movie
import com.google.gson.Gson

class MoviesXmlLocalDataSource(val sharedPref: SharedPreferences) : MoviesLocalDataSource {

    private val editor = sharedPref.edit()
    private val gson = Gson()

    override fun saveMovies(movies: List<Movie>) {
        movies.forEach { movies ->
            editor.putString(movies.id, gson.toJson(movies))
        }
        editor.apply()
    }


    override fun getMovies(): List<Movie> {
        val movies: MutableList<Movie> = mutableListOf()
        sharedPref.all.forEach { map ->
            movies.add(gson.fromJson(map.value as String, Movie::class.java))
        }
        return movies
    }

    override fun getMovieById(movieId: String): Movie? {
        return sharedPref.getString(movieId, null)?.let {
            gson.fromJson(it, Movie::class.java)
        }
    }


}