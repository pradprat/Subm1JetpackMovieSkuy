package com.example.subm1jetpackmovieskuy.movie.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie: Movie? = intent.getParcelableExtra("movie_extra")


        title = movie?.title
        Picasso.get().load("https://image.tmdb.org/t/p/w342"+movie?.backdrop_path).fit().centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(ivPosterMovieDetailBackdrop)
//        ivPosterMovieDetailBackdrop.setImageResource(movie.posterPath)
        Picasso.get().load("https://image.tmdb.org/t/p/w342"+movie?.poster_path).fit().centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(ivPosterMovieDetail)
//        ivPosterMovieDetail.setImageResource(movie.posterPath)
        tvTitleMovieDetail.setText(movie?.title )
        tvOverviewMovieDetail.setText(" release : " + movie?.release_date + " \n"+movie?.overview)
    }
}
