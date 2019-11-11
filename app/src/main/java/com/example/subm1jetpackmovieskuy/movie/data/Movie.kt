package com.example.subm1jetpackmovieskuy.movie.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Movie(
        @SerializedName("popularity") val popularity: Double,
        @SerializedName("vote_count") val vote_count: Int,
        @SerializedName("video") val video: Boolean,
        @SerializedName("poster_path") val poster_path: String?,
        @SerializedName("id") val id: Int,
        @SerializedName("adult") val adult: Boolean,
        @SerializedName("backdrop_path") val backdrop_path: String?,
        @SerializedName("original_language") val original_language: String?,
        @SerializedName("original_title") val original_title: String?,
        @SerializedName("title") val title: String?,
        @SerializedName("vote_average") val vote_average: Double,
        @SerializedName("overview") val overview: String?,
        @SerializedName("release_date") val release_date: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readDouble(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(popularity)
        parcel.writeInt(vote_count)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeString(poster_path)
        parcel.writeInt(id)
        parcel.writeByte(if (adult) 1 else 0)
        parcel.writeString(backdrop_path)
        parcel.writeString(original_language)
        parcel.writeString(original_title)
        parcel.writeString(title)
        parcel.writeDouble(vote_average)
        parcel.writeString(overview)
        parcel.writeString(release_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }


}
