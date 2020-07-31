package com.example.submissionandroidjetpack.data.source.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String? = "",
    val poster_path: String? = "",
    val backdrop_path: String? = "",
    val title: String? = "",
    val name: String? = "",
    val vote_average: String? = "",
    val overview: String? = "",
    val release_date: String? = "",
    val first_air_date: String? = ""
) : Parcelable {

    fun getRatingBar(): Float = if (vote_average != null) {
        vote_average.toFloat() / 2
    } else {
        0f
    }


    fun getNameTv(): String? = if (title.isNullOrEmpty()) {
        name
    } else {
        title
    }


    fun getDate(): String? = if (release_date.isNullOrEmpty()) {
        first_air_date
    } else {
        release_date
    }
}