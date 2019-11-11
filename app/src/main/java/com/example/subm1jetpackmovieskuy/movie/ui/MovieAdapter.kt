package com.example.subm1jetpackmovieskuy.movie.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.movie.data.Movie

class MovieAdapter(private val movies: ArrayList<Movie>, context: Context) : RecyclerView.Adapter<MovieViewHolder>() {

    var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie: Movie = movies[position]
        holder.bind(movie)
        holder.setOnMovieItemClickListener(object : MovieItemClickListener {
            override fun onMovieItemClickListener(view: View, position: Int) {
                val intent = Intent(mContext, MovieDetailActivity::class.java).apply {
                    putExtra("movie_extra", movie)
                }
                mContext.startActivity(intent)
            }

        })
    }
}