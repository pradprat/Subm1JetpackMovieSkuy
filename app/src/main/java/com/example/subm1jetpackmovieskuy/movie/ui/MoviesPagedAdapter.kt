package com.example.subm1jetpackmovieskuy.movie.ui

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.squareup.picasso.Picasso

class MoviePagedListAdapter internal constructor(private val activity: Activity) : PagedListAdapter<Movie, MoviePagedListAdapter.MoviePagedViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePagedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MoviePagedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviePagedViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            Picasso
                    .get()
                    .load("https://image.tmdb.org/t/p/w342"+movie.poster_path)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.blank_poster)
                    .into(holder.mPoster)
            holder.mTitle.text = movie.title
            holder.mCardView.setOnClickListener {
                val intent = Intent(activity, MovieDetailActivity::class.java)
                intent.putExtra("movie_extra", movie)
                activity.startActivity(intent)
            }
        }
    }

    inner class MoviePagedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mPoster: ImageView
        var mTitle: TextView
        var mCardView:CardView

        init {
            mPoster = itemView.findViewById(R.id.item_movie_poster)
            mTitle = itemView.findViewById(R.id.item_movie_title)
            mCardView = itemView.findViewById(R.id.item_card)
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldMovie: Movie, newMovie: Movie): Boolean {
                return oldMovie.id.equals(newMovie.id)
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldMovie: Movie, newMovie: Movie): Boolean {
                return oldMovie.equals(newMovie)
            }
        }
    }
}