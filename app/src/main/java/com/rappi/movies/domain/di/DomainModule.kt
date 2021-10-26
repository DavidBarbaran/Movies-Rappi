package com.rappi.movies.domain.di

import com.rappi.movies.data.movie.MovieRepositoryImpl
import com.rappi.movies.domain.movie.MovieModelMapper
import com.rappi.movies.domain.movie.MovieRepository
import com.rappi.movies.domain.movie.popular.GetPopularMoviesInteractor
import com.rappi.movies.domain.movie.popular.GetPopularMoviesUseCase
import com.rappi.movies.domain.movie.top.rated.GetTopRatedMoviesInteractor
import com.rappi.movies.domain.movie.top.rated.GetTopRatedMoviesUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<MovieRepository> {
        MovieRepositoryImpl(
            get(),
            get()
        )
    }
    factory<GetPopularMoviesUseCase> { GetPopularMoviesInteractor(get()) }
    factory<GetTopRatedMoviesUseCase> { GetTopRatedMoviesInteractor(get()) }
    factory { MovieModelMapper() }
}