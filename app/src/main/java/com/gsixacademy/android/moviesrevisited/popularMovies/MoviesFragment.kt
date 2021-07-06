package com.gsixacademy.android.moviesrevisited.popularMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.gsixacademy.android.moviesrevisited.R
import com.gsixacademy.android.moviesrevisited.api.ApiServiceBuilder
import com.gsixacademy.android.moviesrevisited.api.MoviesDatabaseApi
import com.gsixacademy.android.moviesrevisited.models.PopularMovies
import com.gsixacademy.android.moviesrevisited.models.PopularMoviesResult
import kotlinx.android.synthetic.main.movies_list_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

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
        val call =request.getPopularMovies("ea0478df617e543ad821dad3b41fa22a")
        call.enqueue(object:Callback<PopularMovies>{
            override fun onResponse(call: Call<PopularMovies>, response: Response<PopularMovies>) {

                if (response.isSuccessful){
                    var movieResponse=response.body()
                    var movieList=movieResponse?.results
                    if (movieList!=null){
                        var moviesListAdapter=MoviesListAdapter(movieList){


                        }
                        recycler_view_movies.layoutManager=GridLayoutManager(context,2)
                        recycler_view_movies.adapter=moviesListAdapter
                    }

                }
                else{}


            }

            override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
                Toast.makeText(activity,t.message,Toast.LENGTH_SHORT)
                    .show()
            }

        })



        
        return view
    }



}