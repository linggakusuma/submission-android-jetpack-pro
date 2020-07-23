package com.example.submissionandroidjetpack.di.module

import com.example.submissionandroidjetpack.MainActivity
import com.example.submissionandroidjetpack.data.source.MovieRepository
import com.example.submissionandroidjetpack.di.ActivityScoped
import com.example.submissionandroidjetpack.utils.ViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity
}