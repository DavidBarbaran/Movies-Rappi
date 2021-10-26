package com.rappi.movies.presentation.di

import com.rappi.movies.presentation.home.home.popular.PopularMoviesViewModel
import com.rappi.movies.presentation.home.home.top.rated.TopRatedMoviesViewModel
import com.rappi.movies.presentation.home.movies.MoviesAdapter
import com.rappi.movies.presentation.home.search.SearchMoviesViewModel
import com.rappi.movies.presentation.navigator.Navigator
import com.rappi.movies.presentation.navigator.NavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

val presentationModule = module {
    single<NavigatorImpl>() bind Navigator::class

    viewModel { PopularMoviesViewModel(get(), get()) }
    viewModel { TopRatedMoviesViewModel(get(), get()) }
    viewModel { SearchMoviesViewModel(get(), get()) }

    factory { MoviesAdapter() }
}