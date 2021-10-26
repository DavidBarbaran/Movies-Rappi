package com.rappi.movies.domain.movie.search

import com.rappi.movies.domain.movie.Movie
import com.rappi.movies.domain.movie.MovieRepository

class SearchMoviesInteractor(
    private val moviesRepository: MovieRepository
) : SearchMoviesUseCase {

    override suspend fun searchMovies(query: String, page: Int): List<Movie> {
        return moviesRepository.searchMovies(query, page)
    }
}