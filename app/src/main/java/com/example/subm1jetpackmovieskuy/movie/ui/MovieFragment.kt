package com.example.subm1jetpackmovieskuy.movie.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.subm1jetpackmovieskuy.R
import com.example.subm1jetpackmovieskuy.movie.data.Movie
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiMain
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.data.source.remote.Webservice
import com.example.subm1jetpackmovieskuy.injetion.Injection
import com.example.subm1jetpackmovieskuy.utils.vo.Status
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment() {
    private lateinit var mViewModel: MovieViewModel
    private lateinit var mMovieRepository: MovieRepository
    private lateinit var mWebservice: Webservice
    val mMovies = ArrayList<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        savedInstanceState?.putSerializable("myList", mMovies);
        super.onActivityCreated(savedInstanceState)

        mWebservice = ApiMain().services
        mMovieRepository = Injection().movieRepository(activity!!.application)
        mViewModel = MovieViewModel(mMovieRepository)

        mViewModel.movies.observe(this.viewLifecycleOwner, Observer {
            if (it.status == Status.SUCCESS){
                if (!mMovies.containsAll(it.data!!)){
                    mMovies.addAll(it.data)
                    Log.d("--movie",mMovies.size.toString())
                    rvMovie.adapter?.notifyDataSetChanged()
                }
            }

        })

        rvMovie.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MovieAdapter(mMovies, context)
        }

    }
    companion object {
        fun newInstance(): MovieFragment {
            return MovieFragment()
        }
    }

}
