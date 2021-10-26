package com.rappi.movies.data.api

import com.rappi.movies.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object RetrofitConfig {

    private const val TIMEOUT_READ = 40L
    private const val TIMEOUT_WRITE = 40L
    private const val TIMEOUT_CONNECT = 30L

    val okHttpClient: OkHttpClient = OkHttpClient
        .Builder()
        .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_WRITE, TimeUnit.SECONDS)
        .addInterceptor(getLoggerInterceptor())
        .addInterceptor(getAddQueryInterceptor())
        .connectTimeout(TIMEOUT_CONNECT, TimeUnit.SECONDS)
        .build()

    private fun getLoggerInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        return interceptor
    }

    private fun getAddQueryInterceptor(): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                var request = chain.request()
                val url = request.url.newBuilder()
                    .addQueryParameter("api_key", BuildConfig.API_KEY)
                    .addQueryParameter("language", "es-PE")
                    .build()
                request = request.newBuilder().url(url).build()
                return chain.proceed(request)
            }
        }
    }
}