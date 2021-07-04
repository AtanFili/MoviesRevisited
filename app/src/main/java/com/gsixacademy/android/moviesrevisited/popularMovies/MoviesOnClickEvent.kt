package com.gsixacademy.android.moviesrevisited.popularMovies

import com.gsixacademy.android.moviesrevisited.models.PopularMoviesResult

sealed class MoviesOnClickEvent {
    data class MovieClicked(val movie:PopularMoviesResult):MoviesOnClickEvent()

}