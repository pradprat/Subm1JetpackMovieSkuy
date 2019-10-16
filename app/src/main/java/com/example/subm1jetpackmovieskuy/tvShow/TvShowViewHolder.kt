package com.example.subm1jetpackmovieskuy.tvShow

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.TvShow


class TvShowViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tvshow, parent, false)) {

    var mPoster: ImageView? = null
    var mName: TextView? = null

    init {
        mPoster = itemView.findViewById(R.id.item_tvshow_poster)
        mName = itemView.findViewById(R.id.item_tvshow_name)
    }

    public fun bind(tvShow: TvShow) {
        mPoster?.setImageResource(tvShow.posterPath)
        mName?.text = tvShow.name
    }


}