package com.example.submissionandroidjetpack.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.submissionandroidjetpack.di.ViewModelKey
import com.example.submissionandroidjetpack.ui.detail.DetailMovieViewModel
import com.example.submissionandroidjetpack.ui.movie.MovieViewModel
import com.example.submissionandroidjetpack.ui.tv.TvViewModel
import com.example.submissionandroidjetpack.utils.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun movieViewModel(viewModel: MovieViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TvViewModel::class)
    internal abstract fun tvViewModel(viewModel: TvViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailMovieViewModel::class)
    internal abstract fun detailMovieViewModel(viewModel: DetailMovieViewModel): ViewModel
}