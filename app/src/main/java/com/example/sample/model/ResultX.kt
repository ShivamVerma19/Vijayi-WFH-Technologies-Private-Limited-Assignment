package com.example.sample.model

import com.example.sample.api.MediaItem
import com.google.gson.annotations.SerializedName

data class ResultX(
    val adult: Boolean,
    val backdrop_path: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    @SerializedName("overview") override val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") override val posterPath: String,
    @SerializedName("release_date") override val releaseDate: String,
    @SerializedName("title") override val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
):MediaItem