package com.example.appcolorblindness.data.helpers.adapters

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("android:visibility")
fun View.setVisibility(visible: Boolean?) {
    visibility = if (visible != null && visible) View.VISIBLE else View.GONE
}