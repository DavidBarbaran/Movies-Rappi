package com.rappi.movies.data.api

import com.rappi.movies.data.base.BaseResponse
import com.rappi.movies.data.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<BaseResponse<MovieResponse>>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<BaseResponse<MovieResponse>>

    @GET("search/movie")
    suspend fun searchMovies(@Query("query") query: String, @Query("page") page: Int): Response<BaseResponse<MovieResponse>>
}