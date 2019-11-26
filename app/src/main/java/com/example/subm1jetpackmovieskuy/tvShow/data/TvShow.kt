package com.example.subm1jetpackmovieskuy.tvShow.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class TvShow(
        @ColumnInfo(name = "original_name")
        @SerializedName("original_name")
        val original_name: String?,
        @ColumnInfo(name = "name")
        @SerializedName("name")
        val name: String?,
        @ColumnInfo(name = "popularity")
        @SerializedName("popularity")
        val popularity: Double,
        @ColumnInfo(name = "vote_count")
        @SerializedName("vote_count")
        val vote_count: Int,
        @ColumnInfo(name = "first_air_date")
        @SerializedName("first_air_date")
        val first_air_date: String?,
        @ColumnInfo(name = "backdrop_path")
        @SerializedName("backdrop_path")
        val backdrop_path: String?,
        @ColumnInfo(name = "original_language")
        @SerializedName("original_language")
        val original_language: String?,
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        @SerializedName("id")
        val id: Int,
        @ColumnInfo(name = "vote_average")
        @SerializedName("vote_average")
        val vote_average: Double,
        @ColumnInfo(name = "overview")
        @SerializedName("overview")
        val overview: String?,
        @ColumnInfo(name = "poster_path")
        @SerializedName("poster_path")
        val poster_path: String?,
        @ColumnInfo(name = "is_favorite")
        var is_favorite: Int = 0
) : Parcelable