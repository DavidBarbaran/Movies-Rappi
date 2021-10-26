package com.rappi.movies.presentation.navigator

import com.rappi.movies.presentation.feature.home.movies.MovieModel

interface Navigator {

    fun goToHome()
    fun goToDetailMovie(movie: MovieModel)
    fun goToPlayMovie(movie: MovieModel)
}