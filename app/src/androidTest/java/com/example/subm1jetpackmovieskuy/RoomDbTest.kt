package com.example.subm1jetpackmovieskuy

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.data.source.room.RoomDao
import com.example.subm1jetpackmovieskuy.data.source.room.RoomDb
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Test

class RoomDbTest {

    private lateinit var userDao: RoomDao
    private lateinit var db: RoomDb

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = RoomDb.getInstance(context)
        userDao = db.roomDao()
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadMovie() {
        val movie: Movie = LocalMain().getMovies().get(0)
        userDao.insertMovie(movie)
        val movieFromDb = userDao.getMovieById(movie.id)
        assertThat(movieFromDb.title, equalTo(movie.title))
    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadTvShow() {
        val tvShow = LocalMain().getTvShows().get(0)
        userDao.insertTvShow(tvShow)
        val tvShowFromDb = userDao.getTvShowById(tvShow.id)
        assertThat(tvShowFromDb.name, equalTo(tvShow.name))
    }


    @Test
    @Throws(Exception::class)
    fun writeAndReadFavMovie() {
        val movie: Movie = LocalMain().getMovies().get(9)
        var movieFromDb = userDao.getMovieById(movie.id)
        try {
            movieFromDb.title.isNullOrEmpty()
            movie.is_favorite = 1
            userDao.insertTestMovie(movie)
            movieFromDb = userDao.getMovieById(movie.id)
            assertThat(movieFromDb.title, equalTo(movie.title))
            assertThat(movieFromDb.is_favorite, equalTo(movie.is_favorite))
        } catch (e: Exception) {
            movie.is_favorite = 1
            userDao.insertTestMovie(movie)
            movieFromDb = userDao.getMovieById(movie.id)
            assertThat(movieFromDb.title, equalTo(movie.title))
            assertThat(movieFromDb.is_favorite, equalTo(movie.is_favorite))
            userDao.deleteMovie(movie)
        }

    }

    @Test
    @Throws(Exception::class)
    fun writeAndReadFavTvShow() {
        val tvShow = LocalMain().getTvShows().get(9)
        var tvShowFromDb = userDao.getTvShowById(tvShow.id)
        try {
            tvShowFromDb.name.isNullOrEmpty()
            tvShow.is_favorite = 1
            userDao.insertTestTvShow(tvShow)
            tvShowFromDb = userDao.getTvShowById(tvShow.id)
            assertThat(tvShowFromDb.name, equalTo(tvShow.name))
            assertThat(tvShowFromDb.is_favorite, equalTo(tvShow.is_favorite))
        } catch (e: Exception) {
            tvShow.is_favorite = 1
            userDao.insertTestTvShow(tvShow)
            tvShowFromDb = userDao.getTvShowById(tvShow.id)
            assertThat(tvShowFromDb.name, equalTo(tvShow.name))
            assertThat(tvShowFromDb.is_favorite, equalTo(tvShow.is_favorite))
            userDao.deleteTvShow(tvShow)
        }
    }
}