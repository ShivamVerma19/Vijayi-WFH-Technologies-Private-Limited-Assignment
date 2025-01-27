package com.example.sample.model

data class Movies(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
)