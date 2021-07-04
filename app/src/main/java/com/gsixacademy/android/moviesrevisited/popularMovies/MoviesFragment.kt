package com.gsixacademy.android.moviesrevisited.popularMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.moviesrevisited.R
import com.gsixacademy.android.moviesrevisited.api.ApiServiceBuilder
import com.gsixacademy.android.moviesrevisited.api.MoviesDatabaseApi
import com.gsixacademy.android.moviesrevisited.models.PopularMoviesResult
import java.util.*
import javax.security.auth.callback.Callback

class MoviesFragment:Fragment() {

    var moviesList=ArrayList<PopularMoviesResult>()
    var request=ApiServiceBuilder.buildService(MoviesDatabaseApi::class.java)
    lateinit var movieListAdapter:MoviesListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.movies_list_fragment,container,false)




        
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val request=ApiServiceBuilder.buildService(MoviesDatabaseApi::class.java)
        val call =request.getPopularMovies("ea0478df617e543ad821dad3b41fa22a")
        call.enqueue(object :Callback<MoviesFragment>)




    }


}