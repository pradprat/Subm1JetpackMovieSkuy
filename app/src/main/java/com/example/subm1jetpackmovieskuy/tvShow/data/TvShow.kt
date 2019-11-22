package com.example.subm1jetpackmovieskuy.tvShow.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
        @SerializedName("original_name") val original_name: String?,
        @SerializedName("name") val name: String?,
        @SerializedName("popularity") val popularity: Double,
        @SerializedName("vote_count") val vote_count: Int,
        @SerializedName("first_air_date") val first_air_date: String?,
        @SerializedName("backdrop_path") val backdrop_path: String?,
        @SerializedName("original_language") val original_language: String?,
        @SerializedName("id") val id: Int,
        @SerializedName("vote_average") val vote_average: Double,
        @SerializedName("overview") val overview: String?,
        @SerializedName("poster_path") val poster_path: String?
):Parcelable