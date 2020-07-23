package com.example.submissionandroidjetpack.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private lateinit var movieViewModel: MovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<Movie>>


    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        movieViewModel = MovieViewModel(movieRepository)
    }

    @Test
    fun getTestMovie() {
        runBlocking {
            launch(Dispatchers.Main) {
                val dummyMovie = DataDummy.generateDummyMovie()
                val movie = MutableLiveData<List<Movie>>()
                movie.value = dummyMovie

                Mockito.`when`(movieRepository.getAllMovie()).thenReturn(movie)
                Mockito.verify<MovieRepository>(movieRepository).getAllMovie()

                movieViewModel.movie.observeForever(observer)
                verify(observer).onChanged(dummyMovie)
            }
        }
    }
}