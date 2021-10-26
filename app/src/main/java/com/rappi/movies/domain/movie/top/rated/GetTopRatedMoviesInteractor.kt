package com.rappi.movies.domain.movie.top.rated

import com.rappi.movies.domain.movie.Movie
import com.rappi.movies.domain.movie.MovieRepository

class GetTopRatedMoviesInteractor(private val movieRepository: MovieRepository) : GetTopRatedMoviesUseCase {

    override suspend fun getTopRatedMovies(page: Int): List<Movie> {
        return movieRepository.getTopRatedMovies(page)
    }
}