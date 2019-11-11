package com.example.subm1jetpackmovieskuy.movie.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.squareup.picasso.Picasso

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie, parent, false)), View.OnClickListener {


    var mPoster: ImageView
    var mTitle: TextView
    var movieItemClickListener: MovieItemClickListener? = null

    init {
        mPoster = itemView.findViewById(R.id.item_movie_poster)
        mTitle = itemView.findViewById(R.id.item_movie_title)
        itemView.setOnClickListener(this)
    }

    fun bind(movie: Movie) {
//        mPoster.setImageResource(movie.posterPath)
        mTitle.text = movie.title
        //https://image.tmdb.org/t/p/w500
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w342"+movie.poster_path)
                .fit()
                .centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(mPoster)

    }

    fun setOnMovieItemClickListener(itemClickListener: MovieItemClickListener) {
        this.movieItemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        this.movieItemClickListener!!.onMovieItemClickListener(v!!, adapterPosition)
    }

}