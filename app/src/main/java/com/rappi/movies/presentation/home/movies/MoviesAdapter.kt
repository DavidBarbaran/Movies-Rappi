package com.rappi.movies.presentation.home.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rappi.movies.R

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.PopularMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PopularMovieViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
    )

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 30
    }

    inner class PopularMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind() {

        }
    }
}