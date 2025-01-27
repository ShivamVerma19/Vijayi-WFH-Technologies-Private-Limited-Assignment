package com.example.sample.repository

import com.example.sample.api.ApiInterface

class MovieRepository(private val apiInterface: ApiInterface) {
    suspend fun fetchMovies() = try {
        val response = apiInterface.getMovies()
        if (response.isSuccessful) {
            Result.success(response.body()?.results ?: emptyList())
        } else {
            Result.failure(Exception(response.message()))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun fetchTvShows() = try {
        val response = apiInterface.getTvShows()
        if (response.isSuccessful) {
            Result.success(response.body()?.results ?: emptyList())
        } else {
            Result.failure(Exception(response.message()))
        }
    } catch (e: Exception) {
        Result.failure(e)
    }
}
