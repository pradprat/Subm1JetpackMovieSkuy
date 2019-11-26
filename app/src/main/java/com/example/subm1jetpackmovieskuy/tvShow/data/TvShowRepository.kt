package com.example.subm1jetpackmovieskuy.tvShow.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiResponse
import com.example.subm1jetpackmovieskuy.data.source.remote.NetworkBoundResource
import com.example.subm1jetpackmovieskuy.data.source.remote.RemoteRepository
import com.example.subm1jetpackmovieskuy.data.source.room.LocalRepository
import com.example.subm1jetpackmovieskuy.utils.AppExecutors
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import javax.inject.Singleton

@Singleton
class TvShowRepository constructor(
        private val remoteRepository: RemoteRepository,
        private val localRepository: LocalRepository,
        private val appExecutors: AppExecutors
) {

    fun getPagedTvShows(): LiveData<Resource<PagedList<TvShow>>> {
        return object : NetworkBoundResource<PagedList<TvShow>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShow>> {
                return LivePagedListBuilder(localRepository.getPagingTvShows(), 10).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>): Boolean? {
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

    fun getFavTvShows(): LiveData<Resource<PagedList<TvShow>>> {
        return object : NetworkBoundResource<PagedList<TvShow>, List<TvShow>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShow>> {
                return LivePagedListBuilder(localRepository.getFavTvShows(), 10).build()
            }

            override fun shouldFetch(data: PagedList<TvShow>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<ApiResponse<List<TvShow>>> {
                return MutableLiveData<ApiResponse<List<TvShow>>>()

            }

            override fun saveCallResult(data: List<TvShow>) {
            }
        }.asLiveData()
    }

    fun setFavorite(tvShow: TvShow) {
        val runnable = {
            localRepository.updateTvShow(tvShow)
        }
        appExecutors.diskIO().execute(runnable)
    }
}