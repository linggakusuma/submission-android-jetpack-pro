package com.example.submissionandroidjetpack.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.utils.DataDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.Silent::class)
class TvViewModelTest {

    private var tvViewModel: TvViewModel? = null

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>

    @Before
    fun setUp() {
        tvViewModel = TvViewModel(movieRepository)
    }

    @Test
    fun getTestMovie() {
        val dummyMovie = DataDummy.generateDummyTv()
        val tv = MutableLiveData<List<Movie>>()
        tv.value = dummyMovie
        Mockito.`when`(movieRepository.getAllTv()).thenReturn(tv)
        tvViewModel?.tv?.observeForever(observer)
        Mockito.verify<MovieRepository>(movieRepository).getAllTv()
    }
}