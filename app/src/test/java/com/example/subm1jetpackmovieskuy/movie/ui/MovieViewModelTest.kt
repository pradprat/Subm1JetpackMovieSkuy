package com.example.subm1jetpackmovieskuy.movie.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.subm1jetpackmovieskuy.data.source.LocalMain
import com.example.subm1jetpackmovieskuy.mock
import com.example.subm1jetpackmovieskuy.mockPagedList
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
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
class MovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    private lateinit var movieViewModel: MovieViewModel


    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieRepository = mock()
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        var moviesLiveData = MutableLiveData<Resource<PagedList<Movie>>>()
        val fakeMovies = LocalMain().getMovies()
        var pagedlist = mockPagedList(fakeMovies)
        var movieRes = Resource(Status.SUCCESS, pagedlist, "")
        moviesLiveData.value = movieRes

        movieViewModel.pagedMovies = moviesLiveData

        val observer: Observer<Resource<PagedList<Movie>>> = mock()
        movieViewModel.pagedMovies.observeForever(observer)
        verify(observer).onChanged(movieRes)
    }
}