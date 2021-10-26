package com.rappi.movies.presentation.feature.home.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.HomeListener
import com.rappi.movies.presentation.feature.home.movies.MoviesAdapter
import com.rappi.movies.presentation.navigator.Navigator
import com.rappi.movies.presentation.util.hide
import com.rappi.movies.presentation.util.onEndless
import com.rappi.movies.presentation.util.show
import com.rappi.movies.presentation.util.showToast
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.progressBar
import kotlinx.android.synthetic.main.fragment_search.rvMovies
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject

class SearchMoviesFragment : Fragment() {

    private val viewModel: SearchMoviesViewModel by inject()
    private val adapter: MoviesAdapter by inject()
    private val navigator: Navigator by inject()
    private var homeListener: HomeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeListener = context as HomeListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        homeListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setViewModel()
        setOnClick()
        searchView.showKeyboard()
    }

    private fun setViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                when(it) {
                    SearchMoviesUiState.Loading -> progressBar.show()
                    SearchMoviesUiState.NotLoading -> progressBar.hide()
                    is SearchMoviesUiState.Success -> { adapter.addMovies(it.movies) }
                    is SearchMoviesUiState.Error -> { context?.showToast(it.message) }
                }
            }
        }
    }

    private fun setOnClick() {
        btnBack.setOnClickListener {
            searchView.hideKeyboard()
            homeListener?.goToHome()
        }
        searchView.onActionSearch {
            searchView.hideKeyboard()
            viewModel.searchMovie(searchView.getText())
        }
    }

    private fun setRecyclerView() {
        adapter.setOnClickMovie {
            navigator.goToDetailMovie(it)
            activity?.overridePendingTransition(R.anim.slide_up,R.anim.no_change)
        }
        rvMovies.adapter = adapter
        rvMovies.onEndless {
            viewModel.searchMovie(searchView.getText())
        }
    }

    companion object {
        fun newInstance() = SearchMoviesFragment()
    }
}