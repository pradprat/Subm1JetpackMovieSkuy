package com.example.subm1jetpackmovieskuy.tvShow.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager

import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShow
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiMain
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.movie.ui.MoviePagedListAdapter
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {
    private lateinit var mPagedAdapter: TvShowPagedListAdapter
    private lateinit var mViewModel: TvShowViewModel
    private lateinit var mTvShowRepository: TvShowRepository
    val mTvShows = ArrayList<TvShow>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv_show, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mTvShowRepository = Injection().tvShowRepository(activity!!.application)
        mViewModel = TvShowViewModel(mTvShowRepository)
        mPagedAdapter = TvShowPagedListAdapter(activity!!)

        mViewModel.pagedTvShows.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                when (it.status) {
//                    Status.LOADING -> progressBar.setVisibility(View.VISIBLE)
                    Status.SUCCESS -> {
//                        progressBar.setVisibility(View.GONE)
                        mPagedAdapter.submitList(it.data)
                        mPagedAdapter.notifyDataSetChanged()

                    }
                    Status.ERROR -> {
//                        progressBar.setVisibility(View.GONE)
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        rvTvShow.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = mPagedAdapter
        }

    }

}
