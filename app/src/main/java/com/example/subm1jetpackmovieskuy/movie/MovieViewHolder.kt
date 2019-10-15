package com.example.subm1jetpackmovieskuy.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.Movie

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie, parent, false)) {
    var mPoster: ImageView? = null
    var mTitle: TextView? = null

    init {
        mPoster = itemView.findViewById(R.id.item_movie_poster)
        mTitle = itemView.findViewById(R.id.item_movie_title)
    }

    fun bind(movie: Movie) {
        mPoster?.setImageResource(movie.posterPath)
        mTitle?.text = movie.title
    }


}