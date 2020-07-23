package com.example.submissionandroidjetpack.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.submissionandroidjetpack.databinding.DetailMovieFragmentBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailMovieFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<DetailMovieViewModel> { viewModelFactory }

    private val args: DetailMovieFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DetailMovieFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@DetailMovieFragment
            viewModel = this@DetailMovieFragment.viewModel
        }
        viewModel.setSelectedMovie(args.movie)
        return binding.root
    }
}
