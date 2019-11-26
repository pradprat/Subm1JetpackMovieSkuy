package com.example.subm1jetpackmovieskuy.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieResponse
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowResponse
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteRepository constructor(private val webservice: Webservice) {

    fun getMoviesAsLiveData(): LiveData<ApiResponse<List<Movie>>> {
        val data = MutableLiveData<ApiResponse<List<Movie>>>()
        EspressoIdlingResource.increment()
        webservice.getPopularMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                data.value = ApiResponse.success(response.body()!!.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                var localMain = LocalMain()
                EspressoIdlingResource.decrement()
            }
        })
        return data
    }

    fun getTvShowsAsLiveData(): LiveData<ApiResponse<List<TvShow>>> {
        val data = MutableLiveData<ApiResponse<List<TvShow>>>()
        EspressoIdlingResource.increment()
        webservice.getPopularTvShows().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                data.value = ApiResponse.success(response.body()!!.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                var localMain = LocalMain()
                EspressoIdlingResource.decrement()
            }
        })
        return data
    }
}