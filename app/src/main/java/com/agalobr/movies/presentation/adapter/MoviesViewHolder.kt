package com.agalobr.movies.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.agalobr.app.extensions.loadUrl
import com.agalobr.movies.databinding.ViewItemMoviesFeedBinding
import com.agalobr.movies.domain.GetMoviesFeedUseCase

class MoviesViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(movie: GetMoviesFeedUseCase.MovieFeed) {
        val binding = ViewItemMoviesFeedBinding.bind(view)
        binding.labelGenreMovie.text = movie.genre
        binding.labelNameMovie.text = movie.title
        binding.labelRatingMovie.text = movie.rating
        binding.imgMovie.loadUrl(movie.poster)
    }
}