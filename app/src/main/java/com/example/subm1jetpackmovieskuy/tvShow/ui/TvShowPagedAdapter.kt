package com.example.subm1jetpackmovieskuy.tvShow.ui

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
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.squareup.picasso.Picasso

class TvShowPagedListAdapter internal constructor(private val activity: Activity) : PagedListAdapter<TvShow, TvShowPagedListAdapter.TvShowPagedViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowPagedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tvshow, parent, false)
        return TvShowPagedViewHolder(view)
    }

    override fun onBindViewHolder(holder: TvShowPagedViewHolder, position: Int) {
        val tv_show = getItem(position)
        if (tv_show != null) {
            Picasso
                    .get()
                    .load("https://image.tmdb.org/t/p/w342" + tv_show.poster_path)
                    .fit()
                    .centerCrop()
                    .placeholder(R.drawable.blank_poster)
                    .into(holder.mPoster)
            holder.mTitle.text = tv_show.name
            holder.mCardView.setOnClickListener {
                val intent = Intent(activity, TvShowDetailActivity::class.java)
                intent.putExtra("tvshow_extra", tv_show)
                activity.startActivity(intent)
            }
        }
    }

    inner class TvShowPagedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mPoster: ImageView
        var mTitle: TextView
        var mCardView: CardView

        init {
            mPoster = itemView.findViewById(R.id.item_tvshow_poster)
            mTitle = itemView.findViewById(R.id.item_tvshow_name)
            mCardView = itemView.findViewById(R.id.item_tvshow_card_view)
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShow>() {
            // Concert details may have changed if reloaded from the database,
            // but ID is fixed.
            override fun areItemsTheSame(oldTvShow: TvShow, newTvShow: TvShow): Boolean {
                return oldTvShow.id.equals(newTvShow.id)
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldTvShow: TvShow, newTvShow: TvShow): Boolean {
                return oldTvShow.equals(newTvShow)
            }
        }
    }
}