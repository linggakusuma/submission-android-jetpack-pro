package com.example.submissionandroidjetpack.data.source

import androidx.lifecycle.LiveData
import com.example.submissionandroidjetpack.data.source.remote.response.Movie

interface MovieDataSource {

    fun getAllMovie(): LiveData<List<Movie>>

    fun getAllTv(): LiveData<List<Movie>>

    fun getDetail(movie: Movie): LiveData<Movie>
}