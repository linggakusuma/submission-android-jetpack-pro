package com.example.submissionandroidjetpack.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.submissionandroidjetpack.databinding.MovieFragmentBinding
import com.example.submissionandroidjetpack.ui.ViewPagerFragmentDirections
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MovieViewModel> { viewModelFactory }

    companion object {
        fun newInstance() =
            MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MovieFragmentBinding.inflate(inflater).apply {
            viewModel = this@MovieFragment.viewModel
            lifecycleOwner = this@MovieFragment
            recyclerViewMovie.adapter = MovieAdapter(MovieAdapter.OnClickListener {
                findNavController().navigate(
                    ViewPagerFragmentDirections.actionViewPagerFragmentToDetailMovieFragment(
                        it,
                        it.title.toString()
                    )
                )
            })
        }
        return binding.root
    }
}
