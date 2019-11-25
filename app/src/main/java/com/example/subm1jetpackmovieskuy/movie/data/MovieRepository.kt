package com.example.subm1jetpackmovieskuy.movie.data

import androidx.lifecycle.LiveData
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiResponse
import com.example.subm1jetpackmovieskuy.data.source.remote.NetworkBoundResource
import com.example.subm1jetpackmovieskuy.data.source.remote.RemoteRepository
import com.example.subm1jetpackmovieskuy.data.source.room.LocalRepository
import com.example.subm1jetpackmovieskuy.utils.AppExecutors
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import javax.inject.Singleton



@Singleton
class MovieRepository constructor(
        private val remoteRepository: RemoteRepository,
        private val localRepository: LocalRepository,
        private val appExecutors: AppExecutors
) {

    fun getMovies(): LiveData<Resource<List<Movie>>> {
        return object: NetworkBoundResource<List<Movie>,List<Movie>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Movie>> {
                return  localRepository.getMoviesAsLiveData()
            }
            override fun shouldFetch(data: List<Movie>): Boolean? {
                return data.isEmpty()
            }
            override fun createCall(): LiveData<ApiResponse<List<Movie>>> {
                return remoteRepository.getMoviesAsLiveData()
            }
            override fun saveCallResult(data: List<Movie>) {
                for (movie in data) {
                    localRepository.insertMovie(movie)
                }
            }
        }.asLiveData()
    }

    fun getFavMovies(): LiveData<Resource<List<Movie>>> {
        return object: NetworkBoundResource<List<Movie>,List<Movie>>(appExecutors){
            override fun loadFromDB(): LiveData<List<Movie>> {
                return  localRepository.getFavMoviesAsLiveData()
            }
            override fun shouldFetch(data: List<Movie>): Boolean? {
                return false
            }
            override fun createCall(): LiveData<ApiResponse<List<Movie>>> {
                return remoteRepository.getMoviesAsLiveData()
            }
            override fun saveCallResult(data: List<Movie>) {
            }
        }.asLiveData()
    }

    fun setFavorite(movie: Movie){
        val runnable = {
            localRepository.updateMovie(movie)
        }
        appExecutors.diskIO().execute(runnable)
    }
}