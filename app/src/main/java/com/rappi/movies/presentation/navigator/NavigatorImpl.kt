package com.rappi.movies.presentation.navigator

import android.content.Context
import com.rappi.movies.presentation.feature.detail.DetailMovieActivity
import com.rappi.movies.presentation.feature.home.HomeActivity
import com.rappi.movies.presentation.feature.home.movies.MovieModel

class NavigatorImpl(private val context: Context) : Navigator {

    override fun goToHome() {
        context.startActivity(HomeActivity.getCallingIntent(context))
    }

    override fun goToDetailMovie(movie: MovieModel) {
        context.startActivity(DetailMovieActivity.getCallingIntent(context, movie))
    }
}