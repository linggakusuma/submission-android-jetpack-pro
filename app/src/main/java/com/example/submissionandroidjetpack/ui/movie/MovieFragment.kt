package com.example.submissionandroidjetpack.ui.movie

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.databinding.MovieFragmentBinding
import com.example.submissionandroidjetpack.ui.ViewPagerFragmentDirections
import com.example.submissionandroidjetpack.utils.ext.observe
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieFragment : DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<MovieViewModel> { viewModelFactory }

    private val adapter by lazy { MovieAdapter(MovieAdapter.OnClickListener { navigateToDetail(it) }) }

    private lateinit var binding: MovieFragmentBinding

    companion object {
        fun newInstance() =
            MovieFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = MovieFragmentBinding.inflate(inflater).apply {
            lifecycleOwner = this@MovieFragment
            recyclerViewMovie.adapter = adapter
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
                movie.title.toString()
            )
        )
    }

    private fun subscribeUi() {
        observe(viewModel.movie) {
            Log.d("cekmovie", it.toString())
            adapter.apply {
                submitList(it)
                notifyDataSetChanged()
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}
