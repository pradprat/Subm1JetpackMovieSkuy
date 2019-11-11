package com.example.subm1jetpackmovieskuy.data.source

import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieResponse
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowResponse
import com.example.subm1jetpackmovieskuy.utils.DummyJsonData
import com.google.gson.Gson

class LocalMain {
    fun getMovies():List<Movie>{
        val gson:Gson= Gson()
        return gson.fromJson(DummyJsonData().movies.toString(), MovieResponse::class.java).results
    }
    fun getTvShows():List<TvShow>{
        val gson = Gson()
        return gson.fromJson(DummyJsonData().tvShows, TvShowResponse::class.java).results
    }
}
