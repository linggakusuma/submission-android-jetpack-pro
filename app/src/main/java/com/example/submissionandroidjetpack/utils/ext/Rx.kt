package com.example.submissionandroidjetpack.utils.ext

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.disposedBy(compositeDisposable: CompositeDisposable) =
    compositeDisposable.add(this)