package com.rappi.movies.presentation.feature.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.rappi.movies.R
import com.rappi.movies.presentation.feature.home.movies.MovieModel
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity() {

    private var movie: MovieModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        movie = intent?.extras?.getParcelable(MovieModel.TAG)
        showData()
        setClick()
    }

    private fun showData() {
        tvTitle.text = movie?.title
        tvAverage.text = movie?.voteAverage.toString()
        tvSynopsis.text = movie?.overview
        tvRelease.text = movie?.getYearReleaseDate()
        Glide.with(this)
            .load(movie?.getBackdropPathUrl())
            .placeholder(R.drawable.ic_placeholder_backdrop)
            .into(ivMovie)
    }

    private fun setClick() {
        btnBack.setOnClickListener {
            onBackPressed()
        }
        ivPlay.setOnClickListener {

        }
        btnWatchMovie.setOnClickListener {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_change, R.anim.slide_down)
    }

    companion object {
        fun getCallingIntent(context: Context, movie: MovieModel): Intent {
            return Intent(context, DetailMovieActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
                putExtra(MovieModel.TAG, movie)
            }
        }
    }
}