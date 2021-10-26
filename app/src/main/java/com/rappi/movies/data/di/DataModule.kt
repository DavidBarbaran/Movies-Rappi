package com.rappi.movies.data.di

import com.google.gson.GsonBuilder
import com.rappi.movies.BuildConfig
import com.rappi.movies.data.api.RestApi
import com.rappi.movies.data.api.RetrofitConfig
import com.rappi.movies.data.movie.MovieMapper
import com.rappi.movies.data.movie.video.VideoMapper
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().serializeNulls().create()
                )
            )
            .build().create(RestApi::class.java)
    }

    factory { RetrofitConfig(androidContext()).okHttpClient }

    factory { MovieMapper() }
    factory { VideoMapper() }
}