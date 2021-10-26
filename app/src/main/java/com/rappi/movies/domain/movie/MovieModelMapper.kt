package com.rappi.movies.domain.movie

import com.rappi.movies.presentation.feature.home.movies.MovieModel

class MovieModelMapper {

    fun parse(input: List<Movie>): List<MovieModel> {
        return input.map { parse(it) }
    }

    private fun parse(input: Movie?) = MovieModel(
        adult = input?.adult ?: false,
        backdropPath = input?.backdropPath ?: "",
        id = input?.id ?: 0,
        title = input?.title ?: "",
        overview = input?.overview ?: "",
        posterPath = input?.posterPath ?: "",
        releaseDate = input?.releaseDate ?: "",
        voteAverage = input?.voteAverage ?: 0.0,
    )
}