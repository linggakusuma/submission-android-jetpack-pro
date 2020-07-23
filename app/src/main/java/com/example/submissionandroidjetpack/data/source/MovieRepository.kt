package com.example.submissionandroidjetpack.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.submissionandroidjetpack.data.source.remote.RemoteDataSource
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    private var coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun getAllMovie(): LiveData<List<Movie>> {
        val movieResult = MutableLiveData<List<Movie>>()
        coroutineScope.launch {
            movieResult.value = remoteDataSource.getAllMovie().results
        }
        return movieResult
    }

    override fun getAllTv(): LiveData<List<Movie>> {
        val tvResult = MutableLiveData<List<Movie>>()
        coroutineScope.launch {
            tvResult.value = remoteDataSource.getAllTv().results
        }
        return tvResult
    }

    override fun getDetail(movie: Movie): LiveData<Movie> {
        val detail = MutableLiveData<Movie>()
        detail.value = movie
        return detail
    }
}