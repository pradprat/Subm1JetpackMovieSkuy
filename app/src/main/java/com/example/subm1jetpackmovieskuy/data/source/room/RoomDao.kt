package com.example.subm1jetpackmovieskuy.data.source.room

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import androidx.room.*
import com.example.subm1jetpackmovieskuy.movie.data.Movie


@Dao
interface RoomDao {

    @get:WorkerThread
    @get:Query("SELECT * FROM movie")
    val movies: LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertMovies(movies: List<Movie>)

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertMovie(movie: Movie)

    @Update
    fun updateMovie(movie: Movie)

    @Delete
    fun deleteMovie(movie: Movie)

    @Query("SELECT * FROM movie WHERE id = :movieId")
    fun getMovieById(movieId: String): Movie

}