package com.rappi.movies.presentation.home.movies

import com.rappi.movies.BuildConfig

data class MovieModel(
    val adult: Boolean,
    val backdropPath: String,
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double
) {

    fun getPosterPathUrl() = BuildConfig.BASE_IMAGE_URL + posterPath
}