package com.rappi.movies.presentation.feature.home.movies

import android.os.Parcelable
import com.rappi.movies.BuildConfig
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(
    val adult: Boolean,
    val backdropPath: String,
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double
) : Parcelable {

    fun getPosterPathUrl() = "${BuildConfig.BASE_IMAGE_URL}w300/$posterPath"
    fun getBackdropPathUrl() = "${BuildConfig.BASE_IMAGE_URL}original/$backdropPath"
    fun getYearReleaseDate() = releaseDate.substring(0, 4)

    companion object {
        const val TAG = "MovieModel"
    }
}