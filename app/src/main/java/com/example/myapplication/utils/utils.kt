package com.example.myapplication.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter

import com.squareup.picasso.Picasso

@BindingAdapter("setImage")
fun setImage(imageView: ImageView, value: String?) {
    value?.let {
        Picasso.get().load(it).into(imageView)
    }
}