package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import javax.inject.Inject

class TvShowViewModel @Inject constructor(
        private val tvShowRepository: TvShowRepository
) : ViewModel() {
    var tvShows : LiveData<Resource<List<TvShow>>> = tvShowRepository.getTvShows()
    var favTvShows: LiveData<Resource<List<TvShow>>> = tvShowRepository.getFavTvShows()
    var pagedTvShows: LiveData<Resource<PagedList<TvShow>>> = tvShowRepository.getPagedTvShows()
    fun setFavorite(tvShow: TvShow){
        tvShowRepository.setFavorite(tvShow)
    }
}
