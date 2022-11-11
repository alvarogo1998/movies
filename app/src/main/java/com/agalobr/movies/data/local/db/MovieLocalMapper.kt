package com.agalobr.movies.data.local.db

import com.agalobr.movies.domain.Movie

fun MoviesEntity.toDomain(): Movie = Movie(
    this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
)

fun Movie.toEntity() = MoviesEntity(
    this.id, this.title, this.plot, this.genre, this.rating, this.year, this.poster
)