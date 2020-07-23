package com.example.submissionandroidjetpack.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieEntity(
    var id: String,
    var title: String,
    var description: String,
    var poster: String,
    var date: String
) : Parcelable