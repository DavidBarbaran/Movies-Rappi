package com.rappi.movies.presentation.navigator

import android.content.Context
import com.rappi.movies.presentation.home.HomeActivity

class NavigatorImpl(private val context: Context) : Navigator {

    override fun goToHome() {
        context.startActivity(HomeActivity.getCallingIntent(context))
    }
}