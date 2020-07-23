package com.example.submissionandroidjetpack.ui.movie

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroidjetpack.data.source.MovieRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(movieRepository: MovieRepository) :
    ViewModel() {

    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private var _loading = MutableLiveData<Int>()
    val loading: LiveData<Int> = _loading

    val movie = movieRepository.getAllMovie()

    init {
        getMovie()
    }

    private fun getMovie() {
        coroutineScope.launch {
            try {
                _loading.value = View.VISIBLE
                movie
                _loading.value = View.GONE
            } catch (e: Exception) {
                _loading.value = View.GONE
                e.printStackTrace()
            }
        }
    }

}
