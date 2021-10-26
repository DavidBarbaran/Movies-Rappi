package com.rappi.movies.presentation.home.home.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movies.domain.movie.MovieModelMapper
import com.rappi.movies.domain.movie.popular.GetPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PopularMoviesViewModel(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val movieModelMapper: MovieModelMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<PopularMoviesUiState>(PopularMoviesUiState.Loading)
    val uiState: StateFlow<PopularMoviesUiState> = _uiState

    var page = 1
    private var loading = false

    fun getPopularMovies() {
        if (!loading) {
            loading = true

            viewModelScope.launch(Dispatchers.IO) {
                launch(Dispatchers.Main) { _uiState.value = PopularMoviesUiState.Loading }
                runCatching {
                    val movies = getPopularMoviesUseCase.getPopularMovies(page)
                    launch(Dispatchers.Main) {
                        _uiState.value = PopularMoviesUiState.Success(movieModelMapper.parse(movies))
                        _uiState.value =  PopularMoviesUiState.NotLoading
                    }
                    page++
                    loading = false
                }.onFailure {
                    launch(Dispatchers.Main) {
                        val message = it.message.orEmpty()
                        _uiState.value = PopularMoviesUiState.Error(message)
                    }
                    loading = false
                }
            }
        }
    }


}