package com.example.subm1jetpackmovieskuy.tvShow.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.tvShow.data.TvShowRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import kotlinx.android.synthetic.main.fragment_tv_show.*


class TvShowFragment : Fragment() {

    private lateinit var mPagedAdapter: TvShowPagedListAdapter
    private lateinit var mViewModel: TvShowViewModel
    private lateinit var mTvShowRepository: TvShowRepository

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
                    Status.SUCCESS -> {
                        mPagedAdapter.submitList(it.data)
                        mPagedAdapter.notifyDataSetChanged()
                    }
                    Status.ERROR -> {
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
