package com.example.subm1jetpackmovieskuy.tvShow

import androidx.lifecycle.ViewModelProviders

import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.data.TvShow
import kotlinx.android.synthetic.main.fragment_tv_show.*

class TvShowFragment : Fragment() {

    private var mViewModel: TvShowViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val tvShows = ArrayList<TvShow>()

        mViewModel = ViewModelProviders.of(this).get(TvShowViewModel::class.java)
        mViewModel!!.getTvShows().observe(this, Observer {
            tvShows.addAll(it)
        })

        rvTvShow.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = TvShowAdapter(tvShows, context)
        }

    }

    companion object {

        fun newInstance(): TvShowFragment {
            return TvShowFragment()
        }
    }

}
