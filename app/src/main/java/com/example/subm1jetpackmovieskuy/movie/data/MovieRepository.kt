package com.example.subm1jetpackmovieskuy.movie.data

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.data.source.Webservice
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
        private val webservice: Webservice
) {

    val data = MutableLiveData<List<Movie>>()
    fun getPopularMovies(): LiveData<List<Movie>> {
        EspressoIdlingResource.increment();
        webservice.getPopularMovies().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                data.value = response.body()?.results
                EspressoIdlingResource.decrement();
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                var localMain = LocalMain()
                data.value = localMain.getMovies()
                EspressoIdlingResource.decrement();
            }
        })
        return data
    }
}