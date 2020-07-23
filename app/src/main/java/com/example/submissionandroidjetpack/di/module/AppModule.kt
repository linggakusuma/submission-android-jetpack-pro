package com.example.submissionandroidjetpack.di.module

import android.content.Context
import com.example.submissionandroidjetpack.ui.base.BaseApplication
import dagger.Module
import dagger.Provides

@Module
class AppModule{
    @Provides
    fun providesContext(application:BaseApplication) : Context{
        return application.applicationContext
    }
}