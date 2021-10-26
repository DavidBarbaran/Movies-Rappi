package com.rappi.movies.presentation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rappi.movies.R
import com.rappi.movies.presentation.home.home.HomeFragment
import com.rappi.movies.presentation.home.profile.ProfileFragment
import com.rappi.movies.presentation.home.search.SearchFragment
import com.rappi.movies.presentation.util.backgroundRoundedCorners
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeFragment.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setBottomNavigation()
        goToHomeFragment()
    }

    private fun setBottomNavigation() {
        bottomNavigation.backgroundRoundedCorners(R.dimen.cornerSize)
        bottomNavigation.setOnItemReselectedListener {}
        bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_home -> {
                    goToHomeFragment()
                    true
                }
                R.id.navigation_search -> {
                    goToSearchFragment()
                    true
                }
                R.id.navigation_profile -> {
                    goToProfileFragment()
                    true
                }
                else -> false
            }
        }

    }

    private fun goToHomeFragment() {
        HomeFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    private fun goToSearchFragment() {
        SearchFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    private fun goToProfileFragment() {
        ProfileFragment.newInstance().let {
            supportFragmentManager.beginTransaction().replace(R.id.navHostFragment, it).commit()
        }
    }

    override fun goToSearch() {
        bottomNavigation.selectedItemId = R.id.navigation_search
    }

    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
        }
    }
}