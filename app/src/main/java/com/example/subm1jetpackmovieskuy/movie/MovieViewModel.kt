package com.example.subm1jetpackmovieskuy.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.data.Movie
import com.example.subm1jetpackmovieskuy.utils.DataDummy

class MovieViewModel : ViewModel() {
    private val movies = MutableLiveData<List<Movie>>()

    fun getMovies(): LiveData<List<Movie>> {
        return movies
    }

    fun initLoadMovies() {
        var dataDummy = DataDummy()
        synchronized(dataDummy) {
            movies.value = dataDummy.getMovieDataList()
        }
//        movies.value = dataDummy.getMovieDataList()
        // Do an asynchronous operation to fetch users.
    }
}