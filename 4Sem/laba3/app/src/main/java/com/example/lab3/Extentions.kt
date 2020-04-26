package com.example.lab3

import android.view.View
import android.widget.EditText

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun EditText.setEmpty() {
    this.setText("")
}

fun View.isVisible(): Boolean {
    return this.visibility == View.VISIBLE
}

fun EditText.setEmptyAndGone() {
    this.setEmpty()
    this.gone()
}

fun EditText.isTextEmpty(): Boolean = this.text.toString().isEmpty()