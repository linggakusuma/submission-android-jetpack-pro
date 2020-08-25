package com.example.submissionandroidjetpack.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.databinding.TvFragmentBinding
import com.example.submissionandroidjetpack.ui.ViewPagerFragmentDirections
import com.example.submissionandroidjetpack.ui.movie.MovieAdapter
import com.example.submissionandroidjetpack.utils.ext.observe
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class TvFragment : DaggerFragment() {

    companion object {
        fun newInstance() = TvFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<TvViewModel> { viewModelFactory }

    private val adapter by lazy { MovieAdapter(MovieAdapter.OnClickListener { navigateToDetail(it) }) }

    private lateinit var binding: TvFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TvFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@TvFragment
            recyclerViewTv.adapter = adapter
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUi()
    }


    private fun navigateToDetail(movie: Movie) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailMovieFragment(
                movie,
                movie.name.toString()
            )
        )
    }

    private fun subscribeUi() {
        observe(viewModel.tv) {
            adapter.apply {
                submitList(it)
                notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}
