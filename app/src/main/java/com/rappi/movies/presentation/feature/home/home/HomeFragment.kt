package com.rappi.movies.presentation.feature.home.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.HomeListener
import com.rappi.movies.presentation.feature.home.home.popular.PopularMoviesFragment
import com.rappi.movies.presentation.feature.home.home.top.rated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onDetach() {
        super.onDetach()
        homeListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapters()
        setClick()
    }

    private fun setAdapters() {
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(PopularMoviesFragment.newInstance(), getString(R.string.home_popular))
        adapter.addFragment(TopRatedMoviesFragment.newInstance(), getString(R.string.home_top_rated))
        viewPager?.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = adapter.fragmentTitleList[position]
        }.attach()
    }

    private fun setClick() {
        searchView?.setOnClickListener {
            homeListener?.goToSearch()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}