package com.rappi.movies.domain.movie.popular

import com.rappi.movies.domain.movie.Movie

interface GetPopularMoviesUseCase {

    suspend fun getPopularMovies(page: Int) : List<Movie>
}