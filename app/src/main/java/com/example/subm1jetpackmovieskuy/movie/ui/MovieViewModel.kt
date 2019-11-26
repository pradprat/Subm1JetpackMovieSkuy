package com.example.subm1jetpackmovieskuy.movie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Resource


class MovieViewModel constructor(
        private val movieRepository: MovieRepository
) : ViewModel() {
    var favMovies: LiveData<Resource<PagedList<Movie>>> = movieRepository.getFavMovies()
    var pagedMovies: LiveData<Resource<PagedList<Movie>>> = movieRepository.getPagedMovies()
    fun setFavorite(movie: Movie) {
        movieRepository.setFavorite(movie)
    }

}
