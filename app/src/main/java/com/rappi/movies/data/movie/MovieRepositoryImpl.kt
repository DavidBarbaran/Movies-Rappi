package com.rappi.movies.data.movie

import com.rappi.movies.data.api.RestApi
import com.rappi.movies.data.movie.video.VideoMapper
import com.rappi.movies.data.util.getExceptionByCode
import com.rappi.movies.domain.movie.Movie
import com.rappi.movies.domain.movie.MovieRepository
import com.rappi.movies.domain.movie.video.Video

class MovieRepositoryImpl(
    private val restApi: RestApi,
    private val movieMapper: MovieMapper,
    private val videoMapper: VideoMapper
) : MovieRepository {

    override suspend fun getPopularMovies(page: Int): List<Movie> {
        val response = restApi.getPopularMovies(page)
        if (response.isSuccessful) {
            return movieMapper.parse(response.body()?.results)
        } else {
            throw getExceptionByCode(response.code())
        }
    }

    override suspend fun getTopRatedMovies(page: Int): List<Movie> {
        val response = restApi.getTopRatedMovies(page)
        if (response.isSuccessful) {
            return movieMapper.parse(response.body()?.results)
        } else {
            throw getExceptionByCode(response.code())
        }
    }

    override suspend fun searchMovies(query: String, page: Int): List<Movie> {
        val response = restApi.searchMovies(query, page)
        if (response.isSuccessful) {
            return movieMapper.parse(response.body()?.results)
        } else {
            throw getExceptionByCode(response.code())
        }
    }

    override suspend fun getVideoOfMovie(movieId: Int): Video {
        val response = restApi.getVideosMovie(movieId)
        if (response.isSuccessful) {
            return videoMapper.parse(response.body())
        } else {
            throw getExceptionByCode(response.code())
        }
    }
}