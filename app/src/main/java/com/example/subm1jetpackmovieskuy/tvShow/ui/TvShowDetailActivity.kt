package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.movie.ui.MovieViewModel
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_tv_show_detail.*

class TvShowDetailActivity : AppCompatActivity() {

    lateinit var viewModel: TvShowViewModel
    lateinit var tvShow:TvShow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv_show_detail)

        tvShow = intent.getParcelableExtra("tvshow_extra")

        viewModel = TvShowViewModel(Injection().tvShowRepository(application))

        setMenuClickListener()

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

    fun setMenuClickListener(){
        if (tvShow.is_favorite==1){
            activity_btn_tv_show_favorite.setImageResource(R.drawable.ic_favorite_24px)
        }else{
            activity_btn_tv_show_favorite.setImageResource(R.drawable.ic_favorite_border_24px)
        }
        activity_btn_tv_show_back.setOnClickListener {
            this.finish()
        }
        activity_btn_tv_show_favorite.setOnClickListener {
            if (tvShow.is_favorite==0){
                tvShow.is_favorite=1
                viewModel.setFavorite(tvShow)
                activity_btn_tv_show_favorite.setImageResource(R.drawable.ic_favorite_24px)
                Snackbar.make(window.decorView.rootView,tvShow.name+" added to Favorite", Snackbar.LENGTH_SHORT).show()
            }else{
                tvShow.is_favorite=0
                viewModel.setFavorite(tvShow)
                activity_btn_tv_show_favorite.setImageResource(R.drawable.ic_favorite_border_24px)
                Snackbar.make(window.decorView.rootView,tvShow.name+" removed from Favorite", Snackbar.LENGTH_SHORT).show()

            }
        }
    }
}
