package com.example.subm1jetpackmovieskuy.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.data.Movie
import com.example.subm1jetpackmovieskuy.utils.DataDummy

class MovieViewModel : ViewModel() {
    private val movies = MutableLiveData<List<Movie>>()

    init {
        val dataDummy = DataDummy()
        movies.value = dataDummy.getMovieDataList()
    }

    fun setMovies() {
        val dataDummy = DataDummy()
        movies.value = dataDummy.getMovieDataList()
    }

    fun getMovies(): LiveData<List<Movie>> {
        return movies
    }
}