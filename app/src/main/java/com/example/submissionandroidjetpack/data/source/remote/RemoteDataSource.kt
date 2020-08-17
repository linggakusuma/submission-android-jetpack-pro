package com.example.submissionandroidjetpack.data.source.remote

import com.example.submissionandroidjetpack.data.source.remote.network.MovieApiService
import com.example.submissionandroidjetpack.data.source.remote.response.MovieResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val movieApiService: MovieApiService) {

    suspend fun getAllMovie(): MovieResponse = movieApiService.getMovieAsync().await()

    suspend fun getAllTv(): MovieResponse = movieApiService.getTvAsync().await()
}