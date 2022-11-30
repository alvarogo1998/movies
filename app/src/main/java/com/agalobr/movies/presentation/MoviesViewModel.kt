package com.agalobr.movies.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agalobr.movies.domain.GetMoviesFeedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val getMoviesUseCase: GetMoviesFeedUseCase) : ViewModel() {

    //Publisher
    val movieFeedPublisher: MutableLiveData<MovieUiState> by lazy {
        MutableLiveData<MovieUiState>()
    }

    fun loadMovies() {
        movieFeedPublisher.value = MovieUiState(true)

        viewModelScope.launch(Dispatchers.IO) {
            val moviesFeed = getMoviesUseCase.execute()
            movieFeedPublisher.postValue(
                MovieUiState(
                    isLoading = false,
                    moviesFeed = moviesFeed
                )
            )
        }
    }
    data class MovieUiState(
        val isLoading: Boolean = false,
        val moviesFeed: List<GetMoviesFeedUseCase.MovieFeed> = emptyList()
    )
}