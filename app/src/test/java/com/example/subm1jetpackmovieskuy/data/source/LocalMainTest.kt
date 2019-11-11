package com.example.subm1jetpackmovieskuy.data.source

import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class LocalMainTest {

    private lateinit var localMain:LocalMain
    private lateinit var firstMovie: Movie
    private lateinit var firstTvShow: TvShow

    @Before
    fun setUp() {
        localMain = LocalMain()

    }

    @Test
    fun getMovies() {
        var movies = localMain.getMovies()
        firstMovie = movies.get(0)
        assertEquals(movies.size,20 )
        assertEquals(firstMovie.title,"Joker" )
    }

    @Test
    fun getTvShows() {
        var tvshows = localMain.getTvShows()
        firstTvShow = tvshows.get(0)
        assertEquals(tvshows.size,20 )
        assertEquals(firstTvShow.name,"Supernatural")
    }
}