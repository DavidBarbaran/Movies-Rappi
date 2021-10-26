package com.rappi.movies.domain.movie.video

import com.rappi.movies.domain.movie.MovieRepository

class GetVideoOfMovieInteractor(private val repository: MovieRepository) : GetVideoOfMovieUseCase {

    override suspend fun getVideoOfMovie(movieId: Int): Video {
        return repository.getVideoOfMovie(movieId)
    }
}