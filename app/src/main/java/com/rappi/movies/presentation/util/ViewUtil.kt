package com.rappi.movies.presentation.util

import android.view.View

fun View.show() = run { this.visibility = View.VISIBLE }

fun View.hide() = run { this.visibility = View.GONE }

fun View.invisible() = run { this.visibility = View.INVISIBLE }

fun View.showFade(duration: Long) {
    this.show()
    this.alpha = 0f
    this.animate().setDuration(duration).alpha(1f)
}