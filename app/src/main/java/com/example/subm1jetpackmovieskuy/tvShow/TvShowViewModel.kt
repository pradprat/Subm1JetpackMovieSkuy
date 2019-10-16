package com.example.subm1jetpackmovieskuy.tvShow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.subm1jetpackmovieskuy.data.Movie
import com.example.subm1jetpackmovieskuy.data.TvShow
import com.example.subm1jetpackmovieskuy.utils.DataDummy

class TvShowViewModel : ViewModel() {
    private var tvShows = MutableLiveData<List<TvShow>>()

    init {
        var dataDummy = DataDummy()
        tvShows.value = dataDummy.getTvShowDataList()
    }

    public fun getTvShows(): LiveData<List<TvShow>> {
        return tvShows
    }
}
