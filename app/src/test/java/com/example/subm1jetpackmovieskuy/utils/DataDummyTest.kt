package com.example.subm1jetpackmovieskuy.utils

import com.example.subm1jetpackmovieskuy.data.Movie
import com.example.subm1jetpackmovieskuy.data.TvShow
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DataDummyTest {
    private var dataDummy: DataDummy? = null
    private var movies: ArrayList<Movie>? = null
    private var tvShows: ArrayList<TvShow>? = null

    @Before
    fun setUp() {
        dataDummy = DataDummy()
    }

    @Test
    fun getMovieDataList() {
        val movies = dataDummy?.getMovieDataList()
        assertEquals(10, movies?.size)
        assertEquals("A Star Is Born", movies?.get(0)?.title);
    }

    @Test
    fun getTvShowDataList() {
        val tvShows = dataDummy?.getTvShowDataList()
        assertEquals(10, tvShows?.size)
        assertEquals("Arrow", tvShows?.get(0)?.name);
    }
}