package com.rappi.movies

import android.os.Build
import com.rappi.movies.presentation.feature.detail.DetailMovieActivity
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class DetailMovieActivityTest {

    private lateinit var activity: DetailMovieActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(DetailMovieActivity::class.java)
            .create()
            .resume()
            .get()
    }

    @After
    fun tearDown() {
        stopKoin()
    }

    @Test
    @Throws(Exception::class)
    fun shouldNotBeNull() {
        assertNotNull(activity)
    }

    @Test
    @Throws(Exception::class)
    fun shouldHaveTextSynopsis() {
        val title = activity.tvTitleSynopsis.text
        assertEquals(title, "Sinopsis")
    }

    @Test
    @Throws(Exception::class)
    fun shouldHaveTextRelease() {
        val title = activity.tvTitleRelease.text
        assertEquals(title, "Estreno:")
    }

}