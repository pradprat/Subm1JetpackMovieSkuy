package com.example.subm1jetpackmovieskuy.tvShow.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.squareup.picasso.Picasso


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

    fun bind(tvShow: TvShow) {
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w342" + tvShow.poster_path)
                .fit()
                .centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(mPoster)
        mName.text = tvShow.name
    }

    fun setOnTvshowItemClickListener(itemClickListener: TvshowItemClickListener) {
        this.tvshowItemClickListener = itemClickListener
    }

    override fun onClick(v: View?) {
        this.tvshowItemClickListener!!.onTvshowItemClickListener(v!!, adapterPosition)
    }

}