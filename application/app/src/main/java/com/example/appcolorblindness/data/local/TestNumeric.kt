package com.example.appcolorblindness.data.local

import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.models.Alternative
import com.example.appcolorblindness.data.models.Question
import com.example.appcolorblindness.data.models.Test

class TestNumeric {
    val test = Test().apply {
        testName = "Teste com números"
        listQuestion = listQuestions()
    }

    private fun listQuestions(): List<Question> {
        return listOf(
            Question(R.drawable.ic_number_1, question1(), 1),
            Question(R.drawable.ic_number_2, question2(), 2),
            Question(R.drawable.ic_number_3, question3(), 1),
            Question(R.drawable.ic_number_4, question4(), 3),
            Question(R.drawable.ic_number_5, question5(), 2),
            Question(R.drawable.ic_number_6, question6(), 1),
            Question(R.drawable.ic_number_7, question7(), 2),
            Question(R.drawable.ic_number_8, question8(), 3),
            Question(R.drawable.ic_number_9, question9(), 2),
            Question(R.drawable.ic_number_10, question10(), 1),
        )
    }

    private fun question1(): List<Alternative> {
        return listOf(
            Alternative(1, 2),
            Alternative(2, 3),
            Alternative(3, 9),
            Alternative(4, 0)
        )
    }

    private fun question2(): List<Alternative> {
        return listOf(
            Alternative(1, 9),
            Alternative(2, 6),
            Alternative(3, 2),
            Alternative(4, 0)
        )
    }

    private fun question3(): List<Alternative> {
        return listOf(
            Alternative(1, 4),
            Alternative(2, 1),
            Alternative(3, 7),
            Alternative(4, 0)
        )
    }

    private fun question4(): List<Alternative> {
        return listOf(
            Alternative(1, 1),
            Alternative(2, 10),
            Alternative(3, 7),
            Alternative(4, 0)
        )
    }

    private fun question5(): List<Alternative> {
        return listOf(
            Alternative(1, 4),
            Alternative(2, 5),
            Alternative(3, 8),
            Alternative(4, 0)
        )
    }

    private fun question6(): List<Alternative> {
        return listOf(
            Alternative(1, 7),
            Alternative(2, 10),
            Alternative(3, 5),
            Alternative(4, 0)
        )
    }

    private fun question7(): List<Alternative> {
        return listOf(
            Alternative(1, 10),
            Alternative(2, 1),
            Alternative(3, 4),
            Alternative(4, 0)
        )
    }

    private fun question8(): List<Alternative> {
        return listOf(
            Alternative(1, 6),
            Alternative(2, 8),
            Alternative(3, 3),
            Alternative(4, 0)
        )
    }

    private fun question9(): List<Alternative> {
        return listOf(
            Alternative(1, 4),
            Alternative(2, 8),
            Alternative(3, 3),
            Alternative(4, 0)
        )
    }

    private fun question10(): List<Alternative> {
        return listOf(
            Alternative(1, 2),
            Alternative(2, 8),
            Alternative(3, 6),
            Alternative(4, 0)
        )
    }
}