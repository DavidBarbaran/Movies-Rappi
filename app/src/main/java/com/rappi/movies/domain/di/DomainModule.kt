package com.rappi.movies.domain.di

import com.rappi.movies.data.movie.MovieRepositoryImpl
import com.rappi.movies.domain.movie.MovieModelMapper
import com.rappi.movies.domain.movie.MovieRepository
import com.rappi.movies.domain.movie.popular.GetPopularMoviesInteractor
import com.rappi.movies.domain.movie.popular.GetPopularMoviesUseCase
import com.rappi.movies.domain.movie.search.SearchMoviesInteractor
import com.rappi.movies.domain.movie.search.SearchMoviesUseCase
import com.rappi.movies.domain.movie.top.rated.GetTopRatedMoviesInteractor
import com.rappi.movies.domain.movie.top.rated.GetTopRatedMoviesUseCase
import com.rappi.movies.domain.movie.video.GetVideoOfMovieInteractor
import com.rappi.movies.domain.movie.video.GetVideoOfMovieUseCase
import com.rappi.movies.domain.movie.video.VideoModelMapper
import org.koin.dsl.module

val domainModule = module {
    factory<MovieRepository> {
        MovieRepositoryImpl(
            get(),
            get(),
            get()
        )
    }
    factory<GetPopularMoviesUseCase> { GetPopularMoviesInteractor(get()) }
    factory<GetTopRatedMoviesUseCase> { GetTopRatedMoviesInteractor(get()) }
    factory<SearchMoviesUseCase> { SearchMoviesInteractor(get()) }
    factory { MovieModelMapper() }
    factory<GetVideoOfMovieUseCase> { GetVideoOfMovieInteractor(get()) }
    factory { VideoModelMapper() }
}