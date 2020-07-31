package com.example.submissionandroidjetpack.ui.movie

import androidx.lifecycle.ViewModel
import com.example.submissionandroidjetpack.data.source.MovieRepository
import javax.inject.Inject

class MovieViewModel @Inject constructor(movieRepository: MovieRepository) :
    ViewModel() {
    val movie = movieRepository.getAllMovie()
}
