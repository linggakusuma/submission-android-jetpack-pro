package com.example.submissionandroidjetpack.di.module

import com.example.submissionandroidjetpack.di.FragmentScoped
import com.example.submissionandroidjetpack.ui.ViewPagerFragment
import com.example.submissionandroidjetpack.ui.detail.DetailMovieFragment
import com.example.submissionandroidjetpack.ui.movie.MovieFragment
import com.example.submissionandroidjetpack.ui.tv.TvFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeMovieFragment(): MovieFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeTvFragment(): TvFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeViewPagerFragment(): ViewPagerFragment

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun contributeDetailMovieFragment(): DetailMovieFragment
}