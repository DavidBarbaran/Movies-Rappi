package com.rappi.movies.domain.movie.video

interface GetVideoOfMovieUseCase {
    suspend fun getVideoOfMovie(movieId: Int): Video
}