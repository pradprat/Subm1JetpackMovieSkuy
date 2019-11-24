package com.example.subm1jetpackmovieskuy.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import javax.inject.Inject

class MovieViewModel constructor(
        movieRepository: MovieRepository
) : ViewModel() {
    var movies : LiveData<Resource<List<Movie>>> = movieRepository.getMovies()

}
