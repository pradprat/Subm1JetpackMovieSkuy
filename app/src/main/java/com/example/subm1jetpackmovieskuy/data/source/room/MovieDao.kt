package com.example.subm1jetpackmovieskuy.data.source.room

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.subm1jetpackmovieskuy.movie.data.Movie

@Dao
interface MovieDao {

    @get:Query("SELECT * from movie ORDER BY id ASC")
    val movies: LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie)

    @Delete
    fun delete(movie: Movie)
}