package com.example.subm1jetpackmovieskuy.movie.ui

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*
import org.jetbrains.anko.doAsync
import java.time.Duration
import javax.inject.Inject
import androidx.core.content.ContextCompat.getSystemService
import com.example.subm1jetpackmovieskuy.R
import androidx.core.app.ActivityCompat.startActivityForResult
import android.content.Intent
import androidx.core.content.ContextCompat.getSystemService




class MovieDetailActivity : AppCompatActivity() {

    lateinit var viewModel: MovieViewModel
    lateinit var movie: Movie

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movie = intent.getParcelableExtra("movie_extra")

        viewModel = MovieViewModel(Injection().movieRepository(application))

        setMenuClickListener()

        title = movie.title
        Picasso.get().load("https://image.tmdb.org/t/p/w342"+ movie.backdrop_path).fit().centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(ivPosterMovieDetailBackdrop)
//        ivPosterMovieDetailBackdrop.setImageResource(movie.posterPath)
        Picasso.get().load("https://image.tmdb.org/t/p/w342"+ movie.poster_path).fit().centerCrop()
                .placeholder(R.drawable.blank_poster)
                .into(ivPosterMovieDetail)
//        ivPosterMovieDetail.setImageResource(movie.posterPath)
        tvTitleMovieDetail.text = movie.title
        tvOverviewMovieDetail.text = " release : " + movie.release_date + " \n"+ movie.overview
    }

    fun setMenuClickListener(){
        if (movie.is_favorite==1){
            activity_btn_movie_favorite.setImageResource(R.drawable.ic_favorite_24px)
        }else{
            activity_btn_movie_favorite.setImageResource(R.drawable.ic_favorite_border_24px)
        }
        activity_btn_movie_back.setOnClickListener {
            this.finish()
        }
        activity_btn_movie_favorite.setOnClickListener {
            if (movie.is_favorite==0){
                movie.is_favorite=1
                viewModel.setFavorite(movie)
                activity_btn_movie_favorite.setImageResource(R.drawable.ic_favorite_24px)
                Snackbar.make(window.decorView.rootView,movie.title+" added to Favorite", Snackbar.LENGTH_SHORT).show()
            }else{
                movie.is_favorite=0
                viewModel.setFavorite(movie)
                activity_btn_movie_favorite.setImageResource(R.drawable.ic_favorite_border_24px)
                Snackbar.make(window.decorView.rootView,movie.title+" removed from Favorite", Snackbar.LENGTH_SHORT).show()

            }
        }
    }
}
