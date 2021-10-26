package com.rappi.movies.domain.movie

interface MovieRepository {

    suspend fun getPopularMovies(page: Int) : List<Movie>

    suspend fun getTopRatedMovies(page: Int) : List<Movie>

}