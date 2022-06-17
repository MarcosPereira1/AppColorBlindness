package com.example.appcolorblindness.data.local

import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.models.Alternative
import com.example.appcolorblindness.data.models.Question
import com.example.appcolorblindness.data.models.Test

class TestGeometricsShapes {
    val test = Test().apply {
        testName = "Teste com formas geométricas"
        listQuestion = listQuestions()
    }

    private fun listQuestions(): List<Question> {
        return listOf(
            Question(R.drawable.ic_animal_1, question1(), 1),
            Question(R.drawable.ic_animal_2, question2(), 2),
            Question(R.drawable.ic_animal_3, question3(), 1),
            Question(R.drawable.ic_animal_4, question4(), 3),
            Question(R.drawable.ic_animal_5, question5(), 2),
            Question(R.drawable.ic_animal_6, question6(), 1),
            Question(R.drawable.ic_animal_7, question7(), 3)
        )
    }

    private fun question1(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_animal_peixe),
            Alternative(2, R.drawable.ic_animal_passaro),
            Alternative(3, R.drawable.ic_animal_borboleta),
            Alternative(4, 0)
        )
    }

    private fun question2(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_animal_gato),
            Alternative(2, R.drawable.ic_animal_coelho),
            Alternative(3, R.drawable.ic_animal_peixe),
            Alternative(4, 0)
        )
    }

    private fun question3(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_animal_borboleta),
            Alternative(2, R.drawable.ic_animal_coelho),
            Alternative(3, R.drawable.ic_animal_elefante),
            Alternative(4, 0)
        )
    }

    private fun question4(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_animal_elefante),
            Alternative(2, R.drawable.ic_animal_pato),
            Alternative(3, R.drawable.ic_animal_girafa),
            Alternative(4, 0)
        )
    }

    private fun question5(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_animal_cachorro),
            Alternative(2, R.drawable.ic_animal_pato),
            Alternative(3, R.drawable.ic_animal_girafa),
            Alternative(4, 0)
        )
    }

    private fun question6(): List<Alternative> {
        return listOf(
            Alternative(1,  R.drawable.ic_animal_golfinho),
            Alternative(2, R.drawable.ic_animal_peixe),
            Alternative(3, R.drawable.ic_animal_pato),
            Alternative(4, 0)
        )
    }

    private fun question7(): List<Alternative> {
        return listOf(
            Alternative(1,  R.drawable.ic_animal_gato),
            Alternative(2, R.drawable.ic_animal_borboleta),
            Alternative(3, R.drawable.ic_animal_elefante),
            Alternative(4, 0)
        )
    }
}