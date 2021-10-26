package com.rappi.movies.presentation.home.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment){

    private val fragmentList = ArrayList<Fragment>()
    val fragmentTitleList = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String){
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}