package com.agalobr.movies.data.remote.retrofit

data class MoviesApiModels(
    val id: String,
    val title: String,
    val plot: String,
    val genre: String,
    val rating: String,
    val year: String,
    val poster: String
)