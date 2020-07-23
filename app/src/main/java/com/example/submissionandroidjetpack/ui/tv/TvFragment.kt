package com.example.submissionandroidjetpack.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.submissionandroidjetpack.databinding.TvFragmentBinding
import com.example.submissionandroidjetpack.ui.ViewPagerFragmentDirections
import com.example.submissionandroidjetpack.ui.movie.MovieAdapter
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TvFragment : DaggerFragment() {

    companion object {
        fun newInstance() = TvFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<TvViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = TvFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@TvFragment
            viewModel = this@TvFragment.viewModel
            recyclerViewTv.adapter = MovieAdapter(MovieAdapter.OnClickListener {
                findNavController().navigate(
                    ViewPagerFragmentDirections.actionViewPagerFragmentToDetailMovieFragment(
                        it,
                        it.name.toString()
                    )
                )
            })
        }
        return binding.root
    }

}
