package com.example.subm1jetpackmovieskuy.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import javax.inject.Inject

class MovieViewModel constructor(
        movieRepository: MovieRepository
) : ViewModel() {
    var movies : LiveData<List<Movie>> = movieRepository.getPopularMovies()

}
