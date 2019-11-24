package com.example.subm1jetpackmovieskuy.data.source.room

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.example.subm1jetpackmovieskuy.movie.data.Movie

class LocalRepository constructor(private val dao:RoomDao){
    fun getMoviesAsLiveData(): LiveData<List<Movie>> {
        return dao.movies
    }
    fun insertMovies(movies: List<Movie>){
        dao.insertMovies(movies)
    }

    fun insertMovie(movie: Movie){
        dao.insertMovie(movie)
    }

    fun updateMovie(movie: Movie){
        dao.updateMovie(movie)
    }

    fun deleteMovie(movie: Movie){
        dao.deleteMovie(movie)
    }

    fun getMovieById(movieId: String): Movie{
        return dao.getMovieById(movieId)
    }
}