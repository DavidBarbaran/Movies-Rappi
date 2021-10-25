package com.rappi.movies.presentation.home.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rappi.movies.R
import com.rappi.movies.presentation.home.home.popular.PopularFragment
import com.rappi.movies.presentation.home.home.top.rated.TopRatedFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeListener: HomeListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        homeListener = context as HomeListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDetach() {
        super.onDetach()
        //homeListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        setClick()
    }

    private fun setAdapters() {
        val adapter = ViewPagerAdapter(parentFragmentManager)
        adapter.addFragment(PopularFragment.newInstance(), "Popular")
        adapter.addFragment(TopRatedFragment.newInstance(), "Top Rated")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }

    private fun setClick() {
        searchView?.setOnClickListener {
            homeListener.goToSearch()
        }
    }

    interface HomeListener {
        fun goToSearch()
    }
}