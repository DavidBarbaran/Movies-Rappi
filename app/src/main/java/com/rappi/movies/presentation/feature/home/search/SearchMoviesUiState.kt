package com.rappi.movies.presentation.feature.home.search

import com.rappi.movies.presentation.feature.home.movies.MovieModel

sealed class SearchMoviesUiState {
    object Loading : SearchMoviesUiState()
    object NotLoading : SearchMoviesUiState()
    data class Success(val movies: List<MovieModel>) : SearchMoviesUiState()
    data class Error(val message: String) : SearchMoviesUiState()
}