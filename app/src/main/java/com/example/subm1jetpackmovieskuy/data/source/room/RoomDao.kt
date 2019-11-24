package com.example.subm1jetpackmovieskuy.data.source.room

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import androidx.room.*
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow


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

    @get:WorkerThread
    @get:Query("SELECT * FROM tvshow")
    val tvShows: LiveData<List<TvShow>>
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertTvShows(tvShows: List<TvShow>)
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertTvShow(tvShow: TvShow)
    @Update
    fun updateTvShow(tvShow: TvShow)
    @Delete
    fun deleteTvShow(tvShow: TvShow)
    @Query("SELECT * FROM tvShow WHERE id = :tvShowId")
    fun getTvShowById(tvShowId: String): TvShow

}