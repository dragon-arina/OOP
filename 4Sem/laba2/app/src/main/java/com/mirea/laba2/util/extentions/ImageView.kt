package com.mirea.laba2.util.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(link: String?) =
    Glide.with(this.context)
        .load("https://raw.githubusercontent.com/wesleywerner/ancient-tech/02decf875616dd9692b31658d92e64a20d99f816/src/images/tech/$link")
        .apply(
            RequestOptions()
                .fitCenter()
                .centerCrop()
        )
        .into(this)