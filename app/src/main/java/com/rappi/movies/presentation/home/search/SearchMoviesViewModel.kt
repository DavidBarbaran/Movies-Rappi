package com.rappi.movies.presentation.home.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rappi.movies.domain.movie.MovieModelMapper
import com.rappi.movies.domain.movie.search.SearchMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchMoviesViewModel(
    private val searchMoviesUseCase: SearchMoviesUseCase,
    private val movieModelMapper: MovieModelMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<SearchMoviesUiState>(SearchMoviesUiState.NotLoading)
    val uiState: StateFlow<SearchMoviesUiState> = _uiState

   private var page = 1
    private var loading = false

    fun searchMovie(query: String) {
        if (!loading) {
            loading = true
            viewModelScope.launch(Dispatchers.IO) {
                launch(Dispatchers.Main) {  _uiState.value =  SearchMoviesUiState.Loading }
                runCatching {
                    val movies = searchMoviesUseCase.searchMovies(query, page)
                    launch(Dispatchers.Main) {
                        _uiState.value = SearchMoviesUiState.Success(movieModelMapper.parse(movies))
                        _uiState.value = SearchMoviesUiState.NotLoading
                    }
                    page++
                    loading = false
                }.onFailure {
                    launch(Dispatchers.Main) {
                        val message = it.message.orEmpty()
                        _uiState.value = SearchMoviesUiState.Error(message)
                        _uiState.value = SearchMoviesUiState.NotLoading
                    }
                    loading = false
                }
            }
        }
    }

}