package com.example.sample.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sample.model.ResultX
import com.example.sample.model.ResultY
import com.example.sample.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _movies = MutableStateFlow<List<ResultX>>(emptyList())
    val movies: StateFlow<List<ResultX>> = _movies

    private val _tvShows = MutableStateFlow<List<ResultY>>(emptyList())
    val tvShows: StateFlow<List<ResultY>> = _tvShows

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchMovies() {
        viewModelScope.launch {
            val result = repository.fetchMovies()
            result.fold(
                onSuccess = { _movies.value = it },
                onFailure = { _errorMessage.value = it.message }
            )
        }
    }

    fun fetchTvShows() {
        viewModelScope.launch {
            val result = repository.fetchTvShows()
            result.fold(
                onSuccess = { _tvShows.value = it },
                onFailure = { _errorMessage.value = it.message }
            )
        }
    }
}