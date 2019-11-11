package com.example.subm1jetpackmovieskuy.tvShow.ui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow

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
                val intent = Intent(mContext, TvShowDetailActivity::class.java).apply {
                    putExtra("tvshow_extra", tvShow)
                }
                mContext.startActivity(intent)
            }

        })

    }

}