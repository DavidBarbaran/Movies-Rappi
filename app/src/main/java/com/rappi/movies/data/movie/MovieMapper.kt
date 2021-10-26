package com.rappi.movies.data.movie

import com.rappi.movies.domain.movie.Movie

class MovieMapper {

    fun parse(input: List<MovieResponse>?): List<Movie> {
        return input.orEmpty().map { parse(it) }
    }

    private fun parse(input: MovieResponse?) = Movie(
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