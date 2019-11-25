package com.example.subm1jetpackmovieskuy.data.source.room

import androidx.paging.DataSource
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow


class LocalRepository constructor(private val dao:RoomDao){
    fun getFavMovies(): DataSource.Factory<Int, Movie> = dao.favoriteMovies
    fun getPagingMovies(): DataSource.Factory<Int, Movie> = dao.moviesPaging
    fun insertMovies(movies: List<Movie>){dao.insertMovies(movies)}
    fun insertMovie(movie: Movie){dao.insertMovie(movie)}
    fun updateMovie(movie: Movie){dao.updateMovie(movie)}
    fun deleteMovie(movie: Movie){dao.deleteMovie(movie)}
    fun getMovieById(movieId: String): Movie= dao.getMovieById(movieId)

    fun getFavTvShows(): DataSource.Factory<Int, TvShow> = dao.favoriteTvShows
    fun getPagingTvShows(): DataSource.Factory<Int, TvShow> = dao.tvShowsPaging
    fun insertTvShows(tvShows: List<TvShow>){dao.insertTvShows(tvShows)}
    fun insertTvShow(tvShow: TvShow){dao.insertTvShow(tvShow)}
    fun updateTvShow(tvShow: TvShow){dao.updateTvShow(tvShow)}
    fun deleteTvShow(tvShow: TvShow){dao.deleteTvShow(tvShow)}
    fun getTvShowById(tvShowId: String): TvShow= dao.getTvShowById(tvShowId)
}