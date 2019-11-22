package com.example.subm1jetpackmovieskuy.movie.data

import android.app.Application
import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.data.source.Webservice
import com.example.subm1jetpackmovieskuy.data.source.room.MovieDao
import com.example.subm1jetpackmovieskuy.utils.EspressoIdlingResource
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
        private val webservice: Webservice,
        private val movieDao:MovieDao
) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor();

    fun getPopularMovies(): LiveData<List<Movie>> {
        val data = MutableLiveData<List<Movie>>()
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

    fun getFavMovies():LiveData<List<Movie>>{
        return movieDao.movies
    }

    fun insert(movie: Movie) {
        executorService.execute(Runnable { movieDao.insert(movie) })
    }

    fun delete(movie: Movie) {
        executorService.execute(Runnable { movieDao.delete(movie) })
    }

    fun update(movie: Movie) {
        executorService.execute(Runnable { movieDao.update(movie) })
    }
}