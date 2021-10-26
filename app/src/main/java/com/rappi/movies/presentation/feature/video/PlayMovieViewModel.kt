package com.rappi.movies.presentation.feature.video

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movies.domain.movie.video.GetVideoOfMovieUseCase
import com.rappi.movies.domain.movie.video.VideoModelMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PlayMovieViewModel(
    private val getVideoOfMovieUseCase: GetVideoOfMovieUseCase,
    private val videoModelMapper: VideoModelMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<PlayMovieUiState>(PlayMovieUiState.Loading)
    val uiState: StateFlow<PlayMovieUiState> = _uiState

    fun getVideoOfMovie(movieId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            launch(Dispatchers.Main) { _uiState.value = PlayMovieUiState.Loading }
            runCatching {
                val video = getVideoOfMovieUseCase.getVideoOfMovie(movieId)
                launch(Dispatchers.Main) {
                    _uiState.value = PlayMovieUiState.Success(videoModelMapper.parse(video))
                    _uiState.value = PlayMovieUiState.NotLoading
                }

            }.onFailure {
                launch(Dispatchers.Main) {
                    val message = it.message.orEmpty()
                    _uiState.value = PlayMovieUiState.Error(message)
                    _uiState.value = PlayMovieUiState.NotLoading
                }
            }
        }
    }
}