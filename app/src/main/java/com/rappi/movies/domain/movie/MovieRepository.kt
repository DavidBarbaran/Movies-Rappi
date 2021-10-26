package com.rappi.movies.domain.movie

import com.rappi.movies.domain.movie.video.Video

interface MovieRepository {

    suspend fun getPopularMovies(page: Int): List<Movie>

    suspend fun getTopRatedMovies(page: Int): List<Movie>

    suspend fun searchMovies(query: String, page: Int): List<Movie>

    suspend fun getVideoOfMovie(movieId: Int) : Video
}