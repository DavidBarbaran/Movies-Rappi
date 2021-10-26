package com.rappi.movies.presentation.feature.home.home.top.rated

import com.rappi.movies.presentation.feature.home.movies.MovieModel

sealed class TopRatedMoviesUiState {
    object Loading : TopRatedMoviesUiState()
    object NotLoading : TopRatedMoviesUiState()
    data class Success(val movies: List<MovieModel>) : TopRatedMoviesUiState()
    data class Error(val message: String) : TopRatedMoviesUiState()
}