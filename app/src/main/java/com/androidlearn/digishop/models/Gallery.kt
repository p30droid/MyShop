package com.androidlearn.digishop.models

import android.os.Parcel
import android.os.Parcelable

data class Gallery(
    val img: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString().toString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Gallery> {
        override fun createFromParcel(parcel: Parcel): Gallery {
            return Gallery(parcel)
        }

        override fun newArray(size: Int): Array<Gallery?> {
            return arrayOfNulls(size)
        }
    }
}