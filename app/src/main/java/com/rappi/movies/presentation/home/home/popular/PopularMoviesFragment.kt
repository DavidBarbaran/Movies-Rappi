package com.rappi.movies.presentation.home.home.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.rappi.movies.R
import com.rappi.movies.presentation.home.movies.MoviesAdapter
import com.rappi.movies.presentation.util.hide
import com.rappi.movies.presentation.util.onEndless
import com.rappi.movies.presentation.util.show
import com.rappi.movies.presentation.util.showToast
import kotlinx.android.synthetic.main.fragment_popular_movies.*
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject

class PopularMoviesFragment : Fragment() {

    private val viewModel: PopularMoviesViewModel by inject()
    private val adapter: MoviesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        setViewModel()
        viewModel.getPopularMovies()
    }

    private fun setRecycler() {
        adapter.clear()
        rvMovies.adapter = adapter
        rvMovies.onEndless {
            viewModel.getPopularMovies()
        }
    }

    private fun setViewModel() {
        viewModel.page = 1
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                when(it) {
                    PopularMoviesUiState.Loading -> progressBar.show()
                    PopularMoviesUiState.NotLoading -> progressBar.hide()
                    is PopularMoviesUiState.Success -> { adapter.addMovies(it.movies) }
                    is PopularMoviesUiState.Error -> { context?.showToast(it.message) }
                }
            }
        }
    }

    companion object {
        fun newInstance() = PopularMoviesFragment()
    }
}