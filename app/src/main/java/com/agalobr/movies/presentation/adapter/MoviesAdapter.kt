package com.agalobr.movies.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agalobr.movies.R
import com.agalobr.movies.domain.GetMoviesFeedUseCase

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {

    private val dataItems = mutableListOf<GetMoviesFeedUseCase.MovieFeed>()

    fun setDataItems(movies: List<GetMoviesFeedUseCase.MovieFeed>) {
        dataItems.clear()
        dataItems.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_item_movies_feed, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(dataItems[position])
    }

    override fun getItemCount(): Int = dataItems.size

}
