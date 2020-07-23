package com.example.submissionandroidjetpack.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.submissionandroidjetpack.data.source.remote.response.Movie
import com.example.submissionandroidjetpack.ui.movie.MovieAdapter

@BindingAdapter("listMovie")
fun recyclerViewMovie(recyclerView: RecyclerView, data: List<Movie>?) {
    val adapter = recyclerView.adapter as MovieAdapter
    adapter.submitList(data)
    adapter.notifyDataSetChanged()
}

@BindingAdapter("image")
fun bindImage(imageView: ImageView, url: String?) {
    url.let {
        Glide.with(imageView.context)
            .load("https://image.tmdb.org/t/p/w500/$url")
            .into(imageView)
    }
}

@BindingAdapter("isGone")
fun isViewGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.VISIBLE else View.GONE
}