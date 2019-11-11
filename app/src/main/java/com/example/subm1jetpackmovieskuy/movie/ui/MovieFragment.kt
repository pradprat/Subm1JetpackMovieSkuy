package com.example.subm1jetpackmovieskuy.movie.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.data.source.Webservice
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private lateinit var mViewModel: MovieViewModel
    private lateinit var mMovieRepository: MovieRepository
    private lateinit var mWebservice: Webservice
    val mMovies = ArrayList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        savedInstanceState?.putSerializable("myList", mMovies);
        super.onActivityCreated(savedInstanceState)

        mWebservice = ApiMain().services
        mMovieRepository = MovieRepository(mWebservice)
        mViewModel = MovieViewModel(mMovieRepository)

        mViewModel.movies.observe(this, Observer {
            if (!mMovies.containsAll(it)){
                mMovies.addAll(it)
                Log.d("--movie",mMovies.size.toString())
                rvMovie.adapter?.notifyDataSetChanged()
            }
        })

        rvMovie.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MovieAdapter(mMovies, context)
        }

    }
    companion object {
        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }

}
