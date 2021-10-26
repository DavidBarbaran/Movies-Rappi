package com.rappi.movies.presentation.home.home.top.rated

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
import kotlinx.android.synthetic.main.fragment_top_rated_movies.rvMovies
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class TopRatedMoviesFragment : Fragment() {

    private val viewModel: TopRatedMoviesViewModel by inject()
    private val adapter: MoviesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_rated_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        setViewModel()
        viewModel.getTopRatedMovies()
    }

    private fun setRecycler() {
        rvMovies.adapter = adapter
        adapter.clear()
        rvMovies.onEndless {
            viewModel.getTopRatedMovies()
        }
    }

    private fun setViewModel() {
        viewModel.page = 1
        lifecycleScope.launch {
            viewModel.uiState.collect {
                when(it) {
                    TopRatedMoviesUiState.Loading -> progressBar.show()
                    TopRatedMoviesUiState.NotLoading -> progressBar.hide()
                    is TopRatedMoviesUiState.Success -> { adapter.addMovies(it.movies) }
                    is TopRatedMoviesUiState.Error -> { context?.showToast(it.message) }
                }
            }
        }
    }

    companion object {
        fun newInstance() = TopRatedMoviesFragment()
    }

}