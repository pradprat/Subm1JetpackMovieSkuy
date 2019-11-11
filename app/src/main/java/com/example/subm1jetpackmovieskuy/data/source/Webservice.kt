package com.example.subm1jetpackmovieskuy.data.source

import com.example.subm1jetpackmovieskuy.movie.data.MovieResponse
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET

interface Webservice {
    @GET("/3/movie/popular?api_key=131f0dd8243582e8f30be76be8808ff1&language=en-US&page=1")
    fun getPopularMovies(): Call<MovieResponse>

    @GET("/3/tv/popular?api_key=131f0dd8243582e8f30be76be8808ff1&language=en-US&page=1")
    fun getPopularTvShows(): Call<TvShowResponse>
}