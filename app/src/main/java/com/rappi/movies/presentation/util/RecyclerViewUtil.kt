package com.rappi.movies.presentation.util

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

inline fun RecyclerView.onEndless(crossinline onEndless: () -> Unit) {

    var visibleItemCount: Int
    var pastVisiblesItems: Int
    var totalItemCount: Int

    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            val mLayoutManager = recyclerView.layoutManager as GridLayoutManager
            if (dy > 0)
            {
                visibleItemCount = mLayoutManager.childCount
                totalItemCount = mLayoutManager.itemCount
                pastVisiblesItems = mLayoutManager.findFirstVisibleItemPosition()


                if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                    onEndless()
                }
            }
        }
    })
}

