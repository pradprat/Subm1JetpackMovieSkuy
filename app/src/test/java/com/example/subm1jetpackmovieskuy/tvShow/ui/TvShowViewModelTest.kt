package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.mock
import com.example.subm1jetpackmovieskuy.mockPagedList
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Resource
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvShowRepository: TvShowRepository

    private lateinit var tvShowViewModel: TvShowViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        tvShowRepository = mock()
        tvShowViewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShows() {
        var tvShowsLiveData = MutableLiveData<Resource<PagedList<TvShow>>>()
        val fakeTvShows = LocalMain().getTvShows()
        var pagedlist = mockPagedList(fakeTvShows)
        var tvShowRes = Resource(Status.SUCCESS, pagedlist, "")
        tvShowsLiveData.value = tvShowRes

        tvShowViewModel.pagedTvShows = tvShowsLiveData

        val observer: Observer<Resource<PagedList<TvShow>>> = mock()
        tvShowViewModel.pagedTvShows.observeForever(observer)
        verify(observer).onChanged(tvShowRes)
    }
}