package com.rappi.movies.presentation.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.rappi.movies.R
import com.rappi.movies.presentation.home.home.HomeFragment
import com.rappi.movies.presentation.util.backgroundRoundedCorners
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeFragment.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setBottomNavigation()
    }

    private fun setBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigation.backgroundRoundedCorners(R.dimen.cornerSize)
        bottomNavigation.setupWithNavController(navController)
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