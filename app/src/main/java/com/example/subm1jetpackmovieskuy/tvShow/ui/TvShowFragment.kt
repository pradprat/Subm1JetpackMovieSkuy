package com.example.subm1jetpackmovieskuy.tvShow.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiMain
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {
    private lateinit var mViewModel: TvShowViewModel
    private lateinit var mTvShowRepository: TvShowRepository
    private lateinit var mWebservice: Webservice
    val mTvShows = ArrayList<TvShow>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mWebservice = ApiMain().services
        mTvShowRepository = TvShowRepository(mWebservice)
        mViewModel = TvShowViewModel(mTvShowRepository)

        mViewModel.tvShows.observe(this, Observer {
            if (!mTvShows.containsAll(it)){
                mTvShows.addAll(it)
                Log.d("--TvShow",mTvShows.size.toString())
                rvTvShow.adapter?.notifyDataSetChanged()
            }
        })

        rvTvShow.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = TvShowAdapter(mTvShows, context)
        }

    }

}
