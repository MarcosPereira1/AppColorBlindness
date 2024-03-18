package com.example.appcolorblindness.data.models

data class Question(
    var imageResourceId: Int,
    var listAlternative: List<Alternative>,
    var correctAlternative: Int
)
