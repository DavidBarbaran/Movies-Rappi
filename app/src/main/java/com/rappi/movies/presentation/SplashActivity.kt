package com.rappi.movies.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rappi.movies.R
import com.rappi.movies.presentation.util.showFade
import com.rappi.movies.presentation.util.withDelay
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setAnimation()
    }

    private fun setAnimation() {
        withDelay(2000) {
            textFor.showFade(700)
            ivRappi.showFade(700)
        }
    }
}