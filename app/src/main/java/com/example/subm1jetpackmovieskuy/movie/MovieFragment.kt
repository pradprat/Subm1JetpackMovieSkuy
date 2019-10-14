package com.example.subm1jetpackmovieskuy.movie

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.subm1jetpackmovieskuy.R

class MovieFragment : Fragment() {

    private var mViewModel: MovieViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(MovieViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {

        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }

}
