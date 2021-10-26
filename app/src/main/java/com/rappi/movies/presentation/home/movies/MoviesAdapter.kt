package com.rappi.movies.presentation.home.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rappi.movies.R
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.PopularMovieViewHolder>() {

    private var list: MutableList<MovieModel>? = null
    private var showInitialShimmer = false
    private var showPaginateShimmer = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PopularMovieViewHolder (
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
    )

    override fun onBindViewHolder(holder: PopularMovieViewHolder, position: Int) {
        list?.get(position)?.run { holder.bind(this) }
    }

    fun clear() {
        list?.clear()
        list = null
        notifyDataSetChanged()
    }

    fun addMovies(movies: List<MovieModel>) {
        if (list == null || showInitialShimmer) {
            showInitialShimmer = false
            list = mutableListOf()
        }

        if (showPaginateShimmer) {
            showPaginateShimmer = false
            list?.removeAt(list?.size?.minus(1) ?: 0)
        }

        if (movies.isEmpty()) {
            notifyItemRemoved(list?.size?.minus(1) ?: 0)
        } else {
            list?.addAll(movies)
            notifyItemRangeInserted(list?.size ?: 0, movies.size)
        }
    }

    override fun getItemCount() = list?.size ?: 0

    inner class PopularMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(movie: MovieModel) {
            itemView.apply {
                tvMovie?.text = movie.title
                tvAverage?.text = movie.voteAverage.toString()
                Glide.with(context).load(movie.getPosterPathUrl())
                    .placeholder(R.drawable.ic_placeholder)
                    .into(ivMovie)
            }
        }
    }
}