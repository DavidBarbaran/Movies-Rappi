package com.rappi.movies.presentation.feature.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rappi.movies.R
import com.rappi.movies.presentation.navigator.NavigatorImpl
import com.rappi.movies.presentation.util.showFade
import com.rappi.movies.presentation.util.withDelay
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val navigator: NavigatorImpl by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setAnimation()
        goToHome()
    }

    private fun setAnimation() {
        withDelay(DELAY_ANIMATION) {
            tvFor.showFade()
            ivRappi.showFade()
        }
    }

    private fun goToHome() {
        withDelay(DELAY_SPLASH) {
            navigator.goToHome()
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }

    companion object {

        private const val DELAY_SPLASH = 1500L
        private const val DELAY_ANIMATION = 2000L
    }
}