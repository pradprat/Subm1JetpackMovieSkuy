package com.example.subm1jetpackmovieskuy.tvShow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository @Inject constructor(
        private val webservice: Webservice
) {

    val data = MutableLiveData<List<TvShow>>()
    fun getPopularTvShows(): LiveData<List<TvShow>> {
        EspressoIdlingResource.increment();
        webservice.getPopularTvShows().enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                data.value = response.body()?.results
                EspressoIdlingResource.decrement();
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                var localMain = LocalMain()
                data.value = localMain.getTvShows()
                EspressoIdlingResource.decrement();
            }
        })
        return data
    }
}