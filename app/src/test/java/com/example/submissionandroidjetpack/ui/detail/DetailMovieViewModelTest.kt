package com.example.submissionandroidjetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito

class DetailMovieViewModelTest {

    private lateinit var detailMovieViewModel: DetailMovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Movie>

    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel(movieRepository)
    }

    @Test
    fun getTestMovie() {
        val dummyMovie = DataDummy.generateDummyMovie()[0]
        val movie = MutableLiveData<Movie>()
        movie.value = dummyMovie

        Mockito.`when`(movieRepository.getDetail(dummyMovie)).thenReturn(movie)
        Mockito.verify<MovieRepository>(movieRepository).getDetail(dummyMovie)

        detailMovieViewModel.detail().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}

