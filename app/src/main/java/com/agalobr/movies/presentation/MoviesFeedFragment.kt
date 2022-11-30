package com.agalobr.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.agalobr.movies.databinding.FragmentMoviesFeedBinding
import com.agalobr.movies.presentation.adapter.MoviesAdapter

class MoviesFeedFragment : Fragment() {

    private var binding: FragmentMoviesFeedBinding? = null
    private val moviesAdapter = MoviesAdapter()
    private val viewModel by lazy {
        MoviesFactory().getMoviesViewModel(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesFeedBinding.inflate(inflater)
        setupView()
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
        viewModel.loadMovies()
    }

    fun setupView(){
        binding?.apply {
            listMovies.apply {
                adapter = moviesAdapter
                layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            }
        }
    }

    private fun setupObserver(){
        val moviesFeedSubscriber =
            Observer<MoviesViewModel.MovieUiState>{ uiState ->
                moviesAdapter.setDataItems(uiState.moviesFeed)
            }
        viewModel.movieFeedPublisher.observe(viewLifecycleOwner, moviesFeedSubscriber)
    }
}