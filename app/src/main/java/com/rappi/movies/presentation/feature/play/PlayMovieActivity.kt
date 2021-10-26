package com.rappi.movies.presentation.feature.play

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.rappi.movies.BuildConfig
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.movies.MovieModel
import com.rappi.movies.presentation.util.showToast
import kotlinx.android.synthetic.main.activity_play_movie.*

class PlayMovieActivity : YouTubeBaseActivity() {

    private var movie: MovieModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_movie)
        movie = intent?.extras?.getParcelable(MovieModel.TAG)
        ypView.initialize(BuildConfig.YOUTUBE_API_KEY, object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youTubePlayer: YouTubePlayer?, p2: Boolean) {
                youTubePlayer?.loadVideo("")
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                showToast(getString(R.string.play_movie_error))
            }
        })
    }

    companion object {
        fun getCallingIntent(context: Context, movie: MovieModel): Intent {
            return Intent(context, PlayMovieActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(MovieModel.TAG, movie)
            }
        }
    }
}