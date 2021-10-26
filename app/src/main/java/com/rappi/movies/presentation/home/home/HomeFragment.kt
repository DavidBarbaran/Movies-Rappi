package com.rappi.movies.presentation.home.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.rappi.movies.R
import com.rappi.movies.presentation.home.home.popular.PopularMoviesFragment
import com.rappi.movies.presentation.home.home.top.rated.TopRatedMoviesFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_home, container, false)
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
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(PopularMoviesFragment.newInstance(), "Popular")
        adapter.addFragment(TopRatedMoviesFragment.newInstance(), "Top Rated")
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                tab.text = adapter.fragmentTitleList[position]
            }
        }).attach()

            // tabLayout.setupWithViewPager(viewPager, lifecycle)
    }

    private fun setClick() {
        searchView?.setOnClickListener {
            homeListener.goToSearch()
        }
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    interface HomeListener {
        fun goToSearch()
    }
}