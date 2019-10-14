package com.example.subm1jetpackmovieskuy.tvShow

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.subm1jetpackmovieskuy.R

class TvShowFragment : Fragment() {

    private var mViewModel: TvShowViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
        // TODO: Use the ViewModel
    }

    companion object {

        fun newInstance(): TvShowFragment {
            return TvShowFragment()
        }
    }

}
