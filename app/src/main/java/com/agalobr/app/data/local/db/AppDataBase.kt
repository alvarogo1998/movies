package com.agalobr.app.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.agalobr.movies.data.local.db.MoviesDao
import com.agalobr.movies.data.local.db.MoviesEntity

@Database(
    entities = [MoviesEntity::class],
    version = 1
)

abstract class AppDataBase : RoomDatabase (){
    abstract fun movieDao(): MoviesDao
}