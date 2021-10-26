package com.rappi.movies.domain.movie

data class Movie(
    val adult: Boolean,
    val backdropPath: String,
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double
)