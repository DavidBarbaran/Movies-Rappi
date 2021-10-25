package com.rappi.movies.presentation.home.home.top.rated

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rappi.movies.R
import com.rappi.movies.presentation.home.movies.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_top_rated.*

class TopRatedFragment : Fragment() {

    companion object {
        fun newInstance() = TopRatedFragment()
    }

    private lateinit var viewModel: TopRatedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_rated, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TopRatedViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MoviesAdapter()
        rvMovies.adapter = adapter
    }

}