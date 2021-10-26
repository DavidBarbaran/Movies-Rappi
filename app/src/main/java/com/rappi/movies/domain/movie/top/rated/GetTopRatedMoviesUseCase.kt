package com.rappi.movies.domain.movie.top.rated

import com.rappi.movies.domain.movie.Movie

interface GetTopRatedMoviesUseCase {

    suspend fun getTopRatedMovies(page: Int): List<Movie>
}