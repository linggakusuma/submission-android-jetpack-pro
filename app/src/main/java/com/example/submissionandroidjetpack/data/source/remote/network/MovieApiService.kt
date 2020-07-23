package com.example.submissionandroidjetpack.data.source.remote.network

import com.example.submissionandroidjetpack.BuildConfig
import com.example.submissionandroidjetpack.data.source.remote.response.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {
    @GET("movie/popular")
    fun getMovieAsync(
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY
    ): Deferred<MovieResponse>

    @GET("tv/popular")
    fun getTvAsync(
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY
    ): Deferred<MovieResponse>
}