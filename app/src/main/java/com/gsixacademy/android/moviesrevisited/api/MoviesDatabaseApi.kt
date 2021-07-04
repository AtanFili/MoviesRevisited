package com.gsixacademy.android.moviesrevisited.api

import com.gsixacademy.android.moviesrevisited.models.PopularMovies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


const val apiKey = "api_key=ea0478df617e543ad821dad3b41fa22a"

interface MoviesDatabaseApi {
    @GET("/movie/popular}"+ apiKey)
    fun getPopularMovies(
        @Query("api_key")api_key:String

    ):Call<PopularMovies>
}