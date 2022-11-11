package com.agalobr.movies.data.local.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val TABLA_NAME_MOVIES = "movie"
const val PK_NAME_MOVIES = "id"

@Entity(tableName = TABLA_NAME_MOVIES)
data class MoviesEntity(

    @PrimaryKey @ColumnInfo(name = PK_NAME_MOVIES) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "plot") val plot: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "rating") val rating: String,
    @ColumnInfo(name = "year") val year: String,
    @ColumnInfo(name = "poster") val poster: String,
)