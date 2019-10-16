package com.example.subm1jetpackmovieskuy.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.data.TvShow

class TvShowAdapter(private val tvShows: ArrayList<TvShow>) :
        RecyclerView.Adapter<TvShowViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TvShowViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows.get(position))
    }

}