package com.example.subm1jetpackmovieskuy.data

import android.os.Parcel
import android.os.Parcelable

class TvShow(
        var posterPath: Int,
        var name: String,
        var firstAirDate: String,
        var overview: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString()!!,
            parcel.readString()!!,
            parcel.readString()!!) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(posterPath)
        parcel.writeString(name)
        parcel.writeString(firstAirDate)
        parcel.writeString(overview)
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
