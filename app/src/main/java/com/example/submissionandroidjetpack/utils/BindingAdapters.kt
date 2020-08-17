package com.example.submissionandroidjetpack.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun bindImage(imageView: ImageView, url: String?) {
    url.let {
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500/$url")
            .into(imageView)
    }
}