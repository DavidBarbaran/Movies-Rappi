package com.rappi.movies.presentation.feature.video

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX
import com.rappi.movies.BuildConfig
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.movies.MovieModel
import com.rappi.movies.presentation.util.hide
import com.rappi.movies.presentation.util.show
import com.rappi.movies.presentation.util.showToast
import kotlinx.android.synthetic.main.activity_play_movie.*
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject

class PlayMovieActivity : AppCompatActivity(), YouTubePlayer.OnInitializedListener {

    private val viewModel: PlayMovieViewModel by inject()
    private var movie: MovieModel? = null
    private var video: VideoModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_movie)
        movie = intent?.extras?.getParcelable(MovieModel.TAG)
        setViewModel()
        movie?.id?.let { viewModel.getVideoOfMovie(it) }
    }

    private fun setViewModel() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect {
                when (it) {
                    PlayMovieUiState.Loading -> progressBar.show()
                    PlayMovieUiState.NotLoading -> progressBar.hide()
                    is PlayMovieUiState.Success -> {
                        video = it.video
                        initializeYoutubePlayerFragment()
                    }
                    is PlayMovieUiState.Error -> {
                        applicationContext.showToast(it.message)
                    }
                }
            }
        }
    }

    private fun initializeYoutubePlayerFragment() {
        val youTubePlayerFragment = supportFragmentManager.findFragmentById(R.id.youtubePlayerFragment) as YouTubePlayerSupportFragmentX?
        youTubePlayerFragment?.initialize(BuildConfig.YOUTUBE_API_KEY, this)
    }

    override fun onInitializationSuccess(
        youTubePlayerProvider: YouTubePlayer.Provider?,
        youTubePlayer: YouTubePlayer?,
        wasRestored: Boolean
    ) {
        youTubePlayer?.loadVideo(video?.key)
    }

    override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
        applicationContext.showToast(getString(R.string.play_movie_error))
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