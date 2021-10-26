package com.rappi.movies

import android.os.Build
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.rappi.movies.presentation.feature.home.HomeActivity
import junit.framework.Assert.assertNotNull
import kotlinx.android.synthetic.main.activity_home.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.stopKoin
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class HomeActivityTest {

    private lateinit var activity: HomeActivity

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(HomeActivity::class.java)
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
    fun shouldHaveBottomNavigationMargin() {
        val bottomNavigationView = activity.bottomNavigation
        val bottomMargin = (bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams).bottomMargin
        assertEquals(20, bottomMargin)
        val topMargin = (bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams).topMargin
        assertEquals(0, topMargin)
        val rightMargin =
            (bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams).rightMargin
        assertEquals(20, rightMargin)
        val leftMargin = (bottomNavigationView.layoutParams as CoordinatorLayout.LayoutParams).leftMargin
        assertEquals(20, leftMargin)
    }
}