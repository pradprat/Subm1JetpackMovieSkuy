package com.example.subm1jetpackmovieskuy.tvShow.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(original_name)
        parcel.writeString(name)
        parcel.writeDouble(popularity)
        parcel.writeInt(vote_count)
        parcel.writeString(first_air_date)
        parcel.writeString(backdrop_path)
        parcel.writeString(original_language)
        parcel.writeInt(id)
        parcel.writeDouble(vote_average)
        parcel.writeString(overview)
        parcel.writeString(poster_path)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TvShow> {
        override fun createFromParcel(parcel: Parcel): TvShow {
            return TvShow(parcel)
        }

        override fun newArray(size: Int): Array<TvShow?> {
            return arrayOfNulls(size)
        }
    }
}