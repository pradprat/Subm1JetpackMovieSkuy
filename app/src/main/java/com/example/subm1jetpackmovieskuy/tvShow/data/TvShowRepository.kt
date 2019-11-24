package com.example.subm1jetpackmovieskuy.tvShow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiResponse
import com.example.subm1jetpackmovieskuy.data.source.remote.NetworkBoundResource
import com.example.subm1jetpackmovieskuy.data.source.remote.RemoteRepository
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import com.example.subm1jetpackmovieskuy.data.source.room.LocalRepository
import com.example.subm1jetpackmovieskuy.utils.AppExecutors
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepository constructor(
        private val remoteRepository: RemoteRepository,
        private val localRepository: LocalRepository,
        private val appExecutors: AppExecutors
) {

    fun getTvShows(): LiveData<Resource<List<TvShow>>> {
        return object: NetworkBoundResource<List<TvShow>,List<TvShow>>(appExecutors){
            override fun loadFromDB(): LiveData<List<TvShow>> {
                return  localRepository.getTvShowsAsLiveData()
            }
            override fun shouldFetch(data: List<TvShow>): Boolean? {
                return data.isEmpty()
            }
            override fun createCall(): LiveData<ApiResponse<List<TvShow>>> {
                return remoteRepository.getTvShowsAsLiveData()

            }
            override fun saveCallResult(data: List<TvShow>) {
                for (tvShow in data) {
                    localRepository.insertTvShow(tvShow)
                }
            }
        }.asLiveData()
    }
}