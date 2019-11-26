package com.example.subm1jetpackmovieskuy.movie.ui

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
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import kotlinx.android.synthetic.main.fragment_movie.*


class MovieFragment : Fragment() {
    private lateinit var mPagedAdapter: MoviePagedListAdapter
    private lateinit var mViewModel: MovieViewModel
    private lateinit var mMovieRepository: MovieRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mMovieRepository = Injection().movieRepository(activity!!.application)
        mViewModel = MovieViewModel(mMovieRepository)
        mPagedAdapter = MoviePagedListAdapter(activity!!)

        mViewModel.pagedMovies.observe(viewLifecycleOwner, Observer {
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

        rvMovie.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = mPagedAdapter
        }

    }

}
