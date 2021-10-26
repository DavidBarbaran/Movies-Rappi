package com.rappi.movies.presentation.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rappi.movies.R
import com.rappi.movies.presentation.home.movies.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProvider(this).get(SearchViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_search, container, false)
        searchViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setOnClick()
        searchView.showKeyboard()
    }

    private fun setOnClick() {
        btnBack.setOnClickListener {
            searchView.hideKeyboard()
        }
        searchView.onActionSearch {

        }
    }

    private fun setRecyclerView() {
        val adapter = MoviesAdapter()
        rvMovies.adapter = adapter
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}