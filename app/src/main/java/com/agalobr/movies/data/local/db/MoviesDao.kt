package com.agalobr.movies.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoviesDao {
    @Insert
    fun saveMovies(moviesEntity: MoviesEntity)

    @Query("SELECT * FROM $TABLA_NAME_MOVIES")
    fun getMovies(): List<MoviesEntity>

    @Query("SELECT * FROM $TABLA_NAME_MOVIES WHERE $PK_NAME_MOVIES = :movieId LIMIT 1")
    fun getMovieById(movieId: String): MoviesEntity?
}