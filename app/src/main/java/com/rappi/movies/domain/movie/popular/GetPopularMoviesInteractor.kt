package com.rappi.movies.domain.movie.popular

import com.rappi.movies.domain.movie.Movie
import com.rappi.movies.domain.movie.MovieRepository

class GetPopularMoviesInteractor(
    private val movieRepository: MovieRepository
) : GetPopularMoviesUseCase {

    override suspend fun getPopularMovies(page: Int): List<Movie> {
        return movieRepository.getPopularMovies(page)
    }
}