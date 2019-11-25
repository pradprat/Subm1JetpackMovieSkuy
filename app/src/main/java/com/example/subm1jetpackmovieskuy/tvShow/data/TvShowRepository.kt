package com.example.subm1jetpackmovieskuy.tvShow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiResponse
import com.example.subm1jetpackmovieskuy.data.source.remote.NetworkBoundResource
import com.example.subm1jetpackmovieskuy.data.source.remote.RemoteRepository
import com.example.subm1jetpackmovieskuy.data.source.room.LocalRepository
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.utils.AppExecutors
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
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

    fun getFavTvShows(): LiveData<Resource<List<TvShow>>> {
        return object: NetworkBoundResource<List<TvShow>,List<TvShow>>(appExecutors){
            override fun loadFromDB(): LiveData<List<TvShow>> {
                return  localRepository.getFavTvShowsAsLiveData()
            }
            override fun shouldFetch(data: List<TvShow>): Boolean? {
                return false
            }
            override fun createCall(): LiveData<ApiResponse<List<TvShow>>> {
                return MutableLiveData<ApiResponse<List<TvShow>>>()

            }
            override fun saveCallResult(data: List<TvShow>) {
            }
        }.asLiveData()
    }

    fun setFavorite(tvShow: TvShow){
        val runnable = {
            localRepository.updateTvShow(tvShow)
        }
        appExecutors.diskIO().execute(runnable)
    }
}