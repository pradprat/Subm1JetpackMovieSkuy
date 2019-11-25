package com.example.subm1jetpackmovieskuy.favorite

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
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.tvShow.ui.TvShowAdapter
import com.example.subm1jetpackmovieskuy.tvShow.ui.TvShowViewModel
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*


class FavoriteTvShowFragment : Fragment() {
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

        mViewModel.favTvShows.observe(this.viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS){
                if (!mTvShows.containsAll(it.data!!)){
                    mTvShows.addAll(it.data)
                    Log.d("--TvShow",mTvShows.size.toString())
                    rvTvShow.adapter?.notifyDataSetChanged()
                }
            }
        })

        rvTvShow.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = TvShowAdapter(mTvShows, context)
        }

    }

}
