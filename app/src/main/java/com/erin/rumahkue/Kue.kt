package com.erin.rumahkue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Kue(
    val imgKue: Int,
    val nameKue: String,
    val descKue: String
) : Parcelable
