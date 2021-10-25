package com.rappi.movies.presentation.home.home.popular

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rappi.movies.R
import com.rappi.movies.presentation.home.movies.MoviesAdapter
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment() {

    companion object {
        fun newInstance() = PopularFragment()
    }

    private lateinit var viewModel: PopularViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopularViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MoviesAdapter()
        rvMovies.adapter = adapter
    }

}