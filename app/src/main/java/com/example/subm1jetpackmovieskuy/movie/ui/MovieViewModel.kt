package com.example.subm1jetpackmovieskuy.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import okhttp3.internal.notifyAll
import javax.inject.Inject

class MovieViewModel constructor(
        private val movieRepository: MovieRepository
) : ViewModel() {
    var movies : LiveData<Resource<List<Movie>>> = movieRepository.getMovies()
    var favMovies : LiveData<Resource<List<Movie>>> = movieRepository.getFavMovies()
    fun setFavorite(movie: Movie){
        movieRepository.setFavorite(movie)
    }

}
