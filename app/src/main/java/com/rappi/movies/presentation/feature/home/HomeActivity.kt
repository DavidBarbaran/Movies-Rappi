package com.rappi.movies.presentation.feature.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.home.HomeFragment
import com.rappi.movies.presentation.feature.home.profile.ProfileFragment
import com.rappi.movies.presentation.feature.home.search.SearchMoviesFragment
import com.rappi.movies.presentation.util.backgroundRoundedCorners
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setBottomNavigation()
        commitHomeFragment()
    }

    private fun setBottomNavigation() {
        bottomNavigation.backgroundRoundedCorners(R.dimen.cornerSize)
        bottomNavigation.setOnItemReselectedListener {}
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    commitHomeFragment()
                    true
                }
                R.id.navigation_search -> {
                    commitSearchFragment()
                    true
                }
                R.id.navigation_profile -> {
                    commitProfileFragment()
                    true
                }
                else -> false
            }
        }

    }

    private fun commitHomeFragment() {
        HomeFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    private fun commitSearchFragment() {
        SearchMoviesFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    private fun commitProfileFragment() {
        ProfileFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    override fun goToSearch() {
        bottomNavigation.selectedItemId = R.id.navigation_search
    }

    override fun goToHome() {
        bottomNavigation.selectedItemId = R.id.navigation_home
    }

    override fun onBackPressed() {
        if (bottomNavigation.selectedItemId == R.id.navigation_home) {
            super.onBackPressed()
        } else {
            bottomNavigation.selectedItemId = R.id.navigation_home
        }
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        }
    }
}