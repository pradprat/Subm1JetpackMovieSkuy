package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import javax.inject.Inject

class TvShowViewModel @Inject constructor(
        tvShowRepository: TvShowRepository
) : ViewModel() {
    var tvShows : LiveData<List<TvShow>> = tvShowRepository.getPopularTvShows()
}
