package com.example.subm1jetpackmovieskuy

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.example.subm1jetpackmovieskuy.data.TvShow
import kotlinx.android.synthetic.main.activity_movie_detail.*
import kotlinx.android.synthetic.main.activity_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        val tvShow: TvShow = intent.getParcelableExtra("tvshow_extra")

        title = tvShow.name
        ivPosterTvShowDetail.setImageResource(tvShow.posterPath)
        ivPosterTvShowDetailBackdrop.setImageResource(tvShow.posterPath)
        tvNameTvShowDetail.setText(tvShow.name)
        tvReleaseTvShowDetail.setText(tvShow.firstAirDate)
        tvOverviewTvShowDetail.setText(tvShow.overview)
    }
}
