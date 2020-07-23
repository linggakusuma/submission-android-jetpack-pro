package com.example.submissionandroidjetpack.ui.tv

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

class TvViewModel @Inject constructor(private val movieRepository: MovieRepository) : ViewModel() {
    val tv = movieRepository.getAllTv()
    fun tv(): LiveData<List<Movie>> = movieRepository.getAllTv()
    private var viewModelJob = Job()
    private var coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private var _loading = MutableLiveData<Int>()
    val loading: LiveData<Int>
        get() = _loading

    init {
        getTv()
    }

    private fun getTv() {
        coroutineScope.launch {
            try {
                _loading.value = View.GONE
            } catch (e: Exception) {
                _loading.value = View.GONE
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
