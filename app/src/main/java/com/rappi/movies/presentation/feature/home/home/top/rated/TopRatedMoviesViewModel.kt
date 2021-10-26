package com.rappi.movies.presentation.feature.home.home.top.rated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movies.domain.movie.MovieModelMapper
import com.rappi.movies.domain.movie.top.rated.GetTopRatedMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TopRatedMoviesViewModel(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val movieModelMapper: MovieModelMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<TopRatedMoviesUiState>(TopRatedMoviesUiState.Loading)
    val uiState: StateFlow<TopRatedMoviesUiState> = _uiState

    var page = 1
    private var loading = false

    fun getTopRatedMovies() {
        if (!loading) {
            loading = true

            viewModelScope.launch(Dispatchers.IO) {
                launch(Dispatchers.Main) {  _uiState.value =  TopRatedMoviesUiState.Loading }
                runCatching {
                    val movies = getTopRatedMoviesUseCase.getTopRatedMovies(page)
                    launch(Dispatchers.Main) {
                        _uiState.value = TopRatedMoviesUiState.Success(movieModelMapper.parse(movies))
                        _uiState.value = TopRatedMoviesUiState.NotLoading
                    }
                    page++
                    loading = false
                }.onFailure {
                    launch(Dispatchers.Main) {
                        val message = it.message.orEmpty()
                        _uiState.value = TopRatedMoviesUiState.Error(message)
                        _uiState.value = TopRatedMoviesUiState.NotLoading
                    }
                    loading = false
                }
            }
        }
    }
}