package com.example.appcolorblindness.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ColorBlindnessViewModel : ViewModel() {
    val usernameLiveData: MutableLiveData<String?>? by lazy {
        MutableLiveData()
    }
}