package com.example.subm1jetpackmovieskuy.tvShow

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.TvShow
import com.example.subm1jetpackmovieskuy.movie.MovieItemClickListener


class TvShowViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_tvshow, parent, false)), View.OnClickListener {


    var mPoster: ImageView
    var mName: TextView
    var tvshowItemClickListener: TvshowItemClickListener? = null

    init {
        mPoster = itemView.findViewById(R.id.item_tvshow_poster)
        mName = itemView.findViewById(R.id.item_tvshow_name)
        itemView.setOnClickListener(this)
    }

    public fun bind(tvShow: TvShow) {
        mPoster.setImageResource(tvShow.posterPath)
        mName.text = tvShow.name
    }

    fun setOnTvshowItemClickListener(itemClickListener: TvshowItemClickListener) {
        this.tvshowItemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        this.tvshowItemClickListener!!.onTvshowItemClickListener(v!!, adapterPosition)
    }

}