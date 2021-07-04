package com.gsixacademy.android.moviesrevisited.popularMovies
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.moviesrevisited.R
import com.gsixacademy.android.moviesrevisited.models.PopularMoviesResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*
import java.util.*

class MoviesListAdapter (
    var moviesList:ArrayList<PopularMoviesResult>,val moviesListOnClickEvent:(MoviesOnClickEvent)->Unit ) :
            RecyclerView.Adapter<RecyclerView.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item,parent,false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myHolder=holder as MyViewHolder
        myHolder.bindData(moviesList[position],position)

    }
    inner class MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        fun bindData(itemModel:PopularMoviesResult,position: Int){
            Picasso.get().load("http://image.tmdb.org/t/p/w185" + itemModel.poster_path).fit()
                .into(itemView.movie_image_view)

            itemView.tv_title.text=itemModel.title

        }
    }


    override fun getItemCount(): Int {
        return moviesList.size

    }

}
