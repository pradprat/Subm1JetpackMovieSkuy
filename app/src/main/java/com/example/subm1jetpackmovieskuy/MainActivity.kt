package com.example.subm1jetpackmovieskuy

import android.os.Bundle
import android.util.Log

import com.google.android.material.bottomnavigation.BottomNavigationView

import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.subm1jetpackmovieskuy.data.source.ApiMain
import com.example.subm1jetpackmovieskuy.movie.data.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(
                R.id.navigation_movie, R.id.navigation_tv_show)
                .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
//-------------------------------------------------------------------------------------
        ApiMain().services.getPopularMovies().enqueue(object :
                Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                //Tulis code jika response sukses
                if(response.code() == 200) {
                    response.body()?.results.let {
                       Log.d("--movies",it.toString())
                    }
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable){
                //Tulis code jika response fail
            }
        })
    }

}
