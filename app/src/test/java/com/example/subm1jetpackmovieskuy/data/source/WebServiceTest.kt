package com.example.subm1jetpackmovieskuy.data.source

import com.example.subm1jetpackmovieskuy.data.source.remote.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class WebServiceTest{

    private lateinit var webservice: Webservice

    @Before
    fun setup() {
        webservice = ApiMain().services
    }

    @Test
    fun testMovieApi() {
        val product = webservice.getPopularMovies().execute().body()
        Assert.assertEquals(product?.results?.size, 20)
    }

    @Test
    fun testTvShowApi() {
        val product = webservice.getPopularTvShows().execute().body()
        Assert.assertEquals(product?.results?.size, 20)
    }
}