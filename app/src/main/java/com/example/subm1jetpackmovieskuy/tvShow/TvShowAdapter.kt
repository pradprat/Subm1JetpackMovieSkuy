package com.example.subm1jetpackmovieskuy.tvShow

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.data.TvShow
import com.example.subm1jetpackmovieskuy.movie.MovieItemClickListener

class TvShowAdapter(private val tvShows: ArrayList<TvShow>, context: Context) :
        RecyclerView.Adapter<TvShowViewHolder>() {

    var mContext = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TvShowViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow: TvShow = tvShows.get(position)
        holder.bind(tvShow)
        holder.setOnTvshowItemClickListener(object : TvshowItemClickListener {
            override fun onTvshowItemClickListener(view: View, position: Int) {
                Toast.makeText(mContext, "haha " + tvShow.name, Toast.LENGTH_LONG).show()

            }

        })

    }

}