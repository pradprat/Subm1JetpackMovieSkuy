package com.example.subm1jetpackmovieskuy.data.source.remote

import android.app.Application
import com.example.subm1jetpackmovieskuy.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//131f0dd8243582e8f30be76be8808ff1
class ApiMain : Application() {
    private val client = OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
            })
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val services: Webservice = retrofit.create(Webservice::class.java)
}