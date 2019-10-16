package com.example.subm1jetpackmovieskuy.movie

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.Movie
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private var mViewModel: MovieViewModel? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val mMovies = ArrayList<Movie>()

//        data handle viewmodel
        this.mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        mViewModel!!.getMovies().observe(this, Observer {
            mMovies.addAll(it)
        })

//        setting recyclerview
        rvMovie.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MovieAdapter(mMovies)
        }
    }
    companion object {
        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }

}
