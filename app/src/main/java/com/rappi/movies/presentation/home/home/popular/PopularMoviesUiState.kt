package com.rappi.movies.presentation.home.home.popular

import com.rappi.movies.presentation.home.movies.MovieModel

sealed class PopularMoviesUiState {
    object Loading : PopularMoviesUiState()
    object NotLoading : PopularMoviesUiState()
    data class Success(val movies: List<MovieModel>) : PopularMoviesUiState()
    data class Error(val message: String) : PopularMoviesUiState()
}