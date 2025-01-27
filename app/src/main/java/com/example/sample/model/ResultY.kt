package com.example.sample.model

import com.example.sample.api.MediaItem
import com.google.gson.annotations.SerializedName

data class ResultY(
    val adult: Boolean,
    val backdrop_path: String,
    @SerializedName("first_air_date") override val releaseDate: String,
    val genre_ids: List<Int>,
    val id: Int,
    @SerializedName("name") override val title: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    @SerializedName("overview") override val overview: String,
    val popularity: Double,
    @SerializedName("poster_path") override val posterPath: String,
    val vote_average: Double,
    val vote_count: Int
):MediaItem