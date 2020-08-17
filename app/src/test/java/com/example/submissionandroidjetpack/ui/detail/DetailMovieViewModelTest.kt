package com.example.submissionandroidjetpack.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private val movie = DataDummy.generateDummyMovie()[0]


    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Movie>

    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel(movieRepository)
        detailMovieViewModel.setSelectedMovie(movie)
    }

    @Test
    fun getTestMovie() {
        val movie = MutableLiveData<Movie>()
        movie.value = this.movie

        Mockito.`when`(movieRepository.getDetail(this.movie)).thenReturn(movie)
        val movieEntity = detailMovieViewModel.detail().value as Movie
        Mockito.verify<MovieRepository>(movieRepository).getDetail(this.movie)
        assertNotNull(movieEntity)
        assertEquals(this.movie.id, movieEntity.id)
        assertEquals(this.movie.backdrop_path, movieEntity.backdrop_path)
        assertEquals(this.movie.first_air_date, movieEntity.first_air_date)
        assertEquals(this.movie.name, movieEntity.name)
        assertEquals(this.movie.overview, movieEntity.overview)
        assertEquals(this.movie.poster_path, movieEntity.poster_path)
        assertEquals(this.movie.release_date, movieEntity.release_date)
        assertEquals(this.movie.title, movieEntity.title)
        assertEquals(this.movie.vote_average, movieEntity.vote_average)

        detailMovieViewModel.detail().observeForever(observer)
        verify(observer).onChanged(this.movie)
    }
}

