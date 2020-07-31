package com.example.submissionandroidjetpack.ui.tv

import androidx.lifecycle.ViewModel
import com.example.submissionandroidjetpack.data.source.MovieRepository
import javax.inject.Inject

class TvViewModel @Inject constructor(movieRepository: MovieRepository) : ViewModel() {
    val tv = movieRepository.getAllTv()
}
