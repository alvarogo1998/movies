package com.agalobr.movies.data.remote.retrofit

import com.agalobr.movies.domain.Movie

fun MoviesApiModels.toDomain(): Movie {
    return Movie(
        this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
    )
}