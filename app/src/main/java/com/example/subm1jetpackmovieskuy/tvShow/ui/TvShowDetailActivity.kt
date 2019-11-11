package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        val tvShow: TvShow = intent.getParcelableExtra("tvshow_extra")

        title = tvShow.name
//        ivPosterTvShowDetail.setImageResource(tvShow.posterPath)
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/w342"+tvShow.poster_path)
                .fit()
                .centerCrop()
                .into(ivPosterTvShowDetail)
//        ivPosterTvShowDetailBackdrop.setImageResource(tvShow.posterPath)
        Picasso
                .get()
                .load("https://image.tmdb.org/t/p/original"+tvShow.backdrop_path)
                .fit()
                .centerCrop()
                .into(ivPosterTvShowDetailBackdrop)
        tvNameTvShowDetail.setText(tvShow.name)
        tvReleaseTvShowDetail.setText(tvShow.first_air_date)
        tvOverviewTvShowDetail.setText(tvShow.overview)
    }
}
