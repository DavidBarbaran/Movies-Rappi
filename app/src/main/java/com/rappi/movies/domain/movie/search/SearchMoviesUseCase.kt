package com.rappi.movies.domain.movie.search

import com.rappi.movies.domain.movie.Movie

interface SearchMoviesUseCase {

    suspend fun searchMovies(query: String, page: Int): List<Movie>
}