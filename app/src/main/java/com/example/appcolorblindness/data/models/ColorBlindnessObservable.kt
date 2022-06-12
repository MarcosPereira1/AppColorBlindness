package com.example.appcolorblindness.data.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.appcolorblindness.BR

class ColorBlindnessObservable : BaseObservable() {

    @Bindable
    var username: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.username)
        }

    @Bindable
    var has5years: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.has5years)
        }
}