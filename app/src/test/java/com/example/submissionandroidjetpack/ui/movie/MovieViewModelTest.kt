package com.example.submissionandroidjetpack.ui.movie

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
class MovieViewModelTest {

    private var movieViewModel: MovieViewModel? = null

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()


    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>


    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getTestMovie() {

        val dummyMovie = DataDummy.generateDummyMovie()
        val movie = MutableLiveData<List<Movie>>()
        movie.value = dummyMovie
        Mockito.`when`(movieRepository.getAllMovie()).thenReturn(movie)
        movieViewModel?.movie?.observeForever(observer)
        Mockito.verify<MovieRepository>(movieRepository).getAllMovie()

    }
}