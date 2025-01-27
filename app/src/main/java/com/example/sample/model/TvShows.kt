package com.example.sample.model

data class TvShows(
    val page: Int,
    val results: List<ResultY>,
    val total_pages: Int,
    val total_results: Int
)