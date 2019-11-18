package com.example.subm1jetpackmovieskuy.tvShow.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.nhaarman.mockitokotlin2.mock
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
        tvShowViewModel = TvShowViewModel(tvShowRepository)
    }

    @Test
    fun getTvShows(){
        val fakeTvShows = LocalMain().getTvShows()
        val tvShows = MutableLiveData<List<TvShow>>()
        tvShows.value = fakeTvShows

        tvShowViewModel.tvShows = tvShows

        val observer: Observer<List<TvShow>> = mock()
        println(tvShowViewModel.tvShows.value?.size.toString())
        tvShowViewModel.tvShows.observeForever(observer)
        verify(observer).onChanged(tvShows.value)
    }
}