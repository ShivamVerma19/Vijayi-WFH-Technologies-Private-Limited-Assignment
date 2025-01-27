package com.example.sample.api

import com.example.sample.model.Movies
import com.example.sample.model.TvShows
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("movie?api_key=b0d27bfacc7ffbd17af04efe550a0849")
    suspend fun getMovies() : Response<Movies>

    @GET("tv?api_key=b0d27bfacc7ffbd17af04efe550a0849")
    suspend fun getTvShows() : Response<TvShows>

}