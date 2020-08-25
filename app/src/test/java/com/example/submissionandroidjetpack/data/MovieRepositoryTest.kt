package com.example.submissionandroidjetpack.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.RemoteDataSource
import com.example.submissionandroidjetpack.data.source.remote.network.MovieApiService
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val service = mock(MovieApiService::class.java)
    private val remote = RemoteDataSource(service)
    private lateinit var movieRepository: MovieRepository

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        movieRepository = MovieRepository(remote)
    }

    @Test
    fun loadAllMovies() {
        suspend {
            `when`(service.getMovieAsync().await()).thenReturn(remote.getAllMovie())
            movieRepository.getAllMovie()
            verify(remote).getAllMovie()
        }
    }

    @Test
    fun loadAllTv() {
        suspend {
            `when`(service.getTvAsync().await()).thenReturn(remote.getAllTv())
            movieRepository.getAllTv()
            verify(remote).getAllTv()
        }
    }

}