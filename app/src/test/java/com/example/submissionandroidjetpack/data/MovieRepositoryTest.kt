package com.example.submissionandroidjetpack.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.submissionandroidjetpack.data.source.remote.RemoteDataSource
import org.junit.Rule
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)


}