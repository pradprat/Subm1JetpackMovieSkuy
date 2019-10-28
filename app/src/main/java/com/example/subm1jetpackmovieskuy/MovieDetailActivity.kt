package com.example.subm1jetpackmovieskuy

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.example.subm1jetpackmovieskuy.data.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movie: Movie = intent.getParcelableExtra("movie_extra")


        title = movie.title
        ivPosterMovieDetailBackdrop.setImageResource(movie.posterPath)
        ivPosterMovieDetail.setImageResource(movie.posterPath)
        tvTitleMovieDetail.setText(movie.title + " (" + movie.releaseDate + ")")
        tvOverviewMovieDetail.setText(movie.overview)
    }
}
