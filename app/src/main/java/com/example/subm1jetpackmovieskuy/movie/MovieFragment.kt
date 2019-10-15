package com.example.subm1jetpackmovieskuy.movie

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.subm1jetpackmovieskuy.R
import kotlin.math.log

class MovieFragment : Fragment() {

    private var mViewModel: MovieViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        mViewModel!!.initLoadMovies()
        mViewModel!!.getMovies().observe(this, Observer { movies ->
            for (movie in movies) {
                Log.d("movie", movie.title)
            }
        })
    }

    companion object {

        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }

}
