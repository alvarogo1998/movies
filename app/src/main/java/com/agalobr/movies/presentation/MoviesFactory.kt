package com.agalobr.movies.presentation

import android.content.Context
import androidx.room.Room
import com.agalobr.app.data.local.db.AppDataBase
import com.agalobr.movies.data.MovieDataRepository
import com.agalobr.movies.data.local.db.MoviesDbLocalDataSource
import com.agalobr.movies.data.remote.retrofit.ApiClient
import com.agalobr.movies.data.remote.retrofit.MoviesRemoteDataSource
import com.agalobr.movies.domain.GetMoviesFeedUseCase
import com.agalobr.movies.domain.MoviesRepository

class MoviesFactory {

    fun getMoviesViewModel(applicationContext: Context) =
        MoviesViewModel(getMovieUseCase(applicationContext))


    private fun getMovieUseCase(context: Context): GetMoviesFeedUseCase {
        return GetMoviesFeedUseCase(
            getMoviesDataRepository(context)
        )
    }

    fun getMoviesDataRepository(context: Context): MoviesRepository {
        return MovieDataRepository(
            MoviesRemoteDataSource(getApiClient()),
            MoviesDbLocalDataSource(DataBaseSingleton.getInstance(context).movieDao())
        )
    }

    private fun getApiClient() = ApiClient()

    object DataBaseSingleton {
        private var db: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java, "db_movie"
                ).build()
            }
            return db!!
        }
    }
}