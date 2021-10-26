package com.rappi.movies.data.api

import com.rappi.movies.data.base.BaseResponse
import com.rappi.movies.data.movie.MovieResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface RestApi {

    @POST("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): Response<BaseResponse<MovieResponse>>

    @POST("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("page") page: Int): Response<BaseResponse<MovieResponse>>

    @POST("movie/movie")
    suspend fun searchMovies(@Query("query") query: String, @Query("page") page: Int): Response<BaseResponse<MovieResponse>>
}