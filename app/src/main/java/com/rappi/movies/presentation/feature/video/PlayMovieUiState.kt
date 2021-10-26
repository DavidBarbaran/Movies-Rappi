package com.rappi.movies.presentation.feature.video

sealed class PlayMovieUiState {
    object Loading : PlayMovieUiState()
    object NotLoading : PlayMovieUiState()
    data class Success(val video: VideoModel) : PlayMovieUiState()
    data class Error(val message: String) : PlayMovieUiState()
}