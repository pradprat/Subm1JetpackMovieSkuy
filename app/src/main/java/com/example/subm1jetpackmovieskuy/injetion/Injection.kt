package com.example.subm1jetpackmovieskuy.injetion

import android.app.Application
import com.example.subm1jetpackmovieskuy.data.source.remote.ApiMain
import com.example.subm1jetpackmovieskuy.data.source.remote.RemoteRepository
import com.example.subm1jetpackmovieskuy.data.source.room.LocalRepository
import com.example.subm1jetpackmovieskuy.data.source.room.RoomDb
import com.example.subm1jetpackmovieskuy.movie.data.MovieRepository
import com.example.subm1jetpackmovieskuy.utils.AppExecutors

class Injection(){
        fun movieRepository(application: Application):MovieRepository{
            val roomdb = RoomDb.getInstance(application)

            var remoteRepository = RemoteRepository(ApiMain().services)
            var localRepository = LocalRepository(roomdb.roomDao())
            val appExecutors = AppExecutors()

            return MovieRepository(remoteRepository,localRepository,appExecutors)
        }
}