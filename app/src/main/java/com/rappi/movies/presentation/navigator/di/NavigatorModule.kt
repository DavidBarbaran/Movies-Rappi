package com.rappi.movies.presentation.navigator.di

import com.rappi.movies.presentation.navigator.Navigator
import com.rappi.movies.presentation.navigator.NavigatorImpl
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

val navigatorModule = module {
    single<NavigatorImpl>() bind Navigator::class
}