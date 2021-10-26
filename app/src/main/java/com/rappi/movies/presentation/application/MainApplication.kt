package com.rappi.movies.presentation.application

import android.app.Application
import com.rappi.movies.data.di.dataModule
import com.rappi.movies.domain.di.domainModule
import com.rappi.movies.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(listOf(dataModule, domainModule, presentationModule))
        }
    }
}