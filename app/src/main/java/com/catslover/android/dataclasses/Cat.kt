package com.catslover.android.dataclasses

import android.os.Parcel
import android.os.Parcelable



data class Cat(var catType: String?, var catfeed: String?, var catImage:Int) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()) {
    }

    override fun describeContents(): Int {
return 0

    }

    override fun writeToParcel(dest: Parcel?, p1: Int) {
        if (dest != null) {
            dest.writeString(catType.toString())
            dest.writeString(catfeed.toString())
            dest.writeInt(catImage)


        };
    }

    companion object CREATOR : Parcelable.Creator<Cat> {
        override fun createFromParcel(parcel: Parcel): Cat {
            return Cat(parcel)
        }

        override fun newArray(size: Int): Array<Cat?> {
            return arrayOfNulls(size)
        }
    }
}