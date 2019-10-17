package com.tiangou.databindingstarted

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import android.databinding.BindingAdapter
import android.widget.ImageView


@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: Int) {

    val context = view.getContext()

    val option = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

    Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(imageUrl)
            .into(view)
}

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String) {

    val context = view.getContext()

    val option = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

    Glide.with(context)
            .setDefaultRequestOptions(option)
            .load(imageUrl)
            .into(view)
}

//
//@BindingAdapter("imageResource")
//fun ImageView.setImageResource(imageUrl: String) {
//
//    val context = this.context
//
//    val option = RequestOptions()
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//
//    Glide.with(context)
//            .setDefaultRequestOptions(option)
//            .load(imageUrl)
//            .into(this)
//}
//
//
//@BindingAdapter("imageResource")
//fun ImageView.setImageResource(imageUrl: Int) {
//
//    val context = this.context
//
//    val option = RequestOptions()
//            .placeholder(R.drawable.ic_launcher_background)
//            .error(R.drawable.ic_launcher_background)
//
//    Glide.with(context)
//            .setDefaultRequestOptions(option)
//            .load(imageUrl)
//            .into(this)
//}