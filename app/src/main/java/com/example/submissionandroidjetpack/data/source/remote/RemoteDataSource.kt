package com.example.submissionandroidjetpack.data.source.remote

import com.example.submissionandroidjetpack.data.source.remote.network.MovieApiService
import com.example.submissionandroidjetpack.data.source.remote.response.MovieResponse
import com.example.submissionandroidjetpack.utils.EspressoIdlingResource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieApiService: MovieApiService) {

    suspend fun getAllMovie(): MovieResponse {
        EspressoIdlingResource.increment()
        val response = movieApiService.getMovieAsync().await()
        EspressoIdlingResource.decrement()
        return response
    }

    suspend fun getAllTv(): MovieResponse {
        EspressoIdlingResource.increment()
        val response = movieApiService.getTvAsync().await()
        EspressoIdlingResource.decrement()
        return response
    }
}