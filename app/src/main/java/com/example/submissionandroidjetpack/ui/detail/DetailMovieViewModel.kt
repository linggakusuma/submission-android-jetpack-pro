package com.example.submissionandroidjetpack.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import javax.inject.Inject

class DetailMovieViewModel @Inject constructor(private val movieRepository: MovieRepository) :
    ViewModel() {
    private lateinit var movie: Movie
    fun setSelectedMovie(movie: Movie) {
        this.movie = movie
    }

    fun detail(): LiveData<Movie> = movieRepository.getDetail(movie)
}
