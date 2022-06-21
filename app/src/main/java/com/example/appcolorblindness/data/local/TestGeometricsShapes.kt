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
            Question(R.drawable.ic_quadrado, question1(), 2),
            Question(R.drawable.ic_circulo, question2(), 3),
            Question(R.drawable.ic_triangulo, question3(), 1),
            Question(R.drawable.ic_coracao, question4(), 3),
            Question(R.drawable.ic_estrela, question5(), 2),
            Question(R.drawable.ic_quadrado_2, question6(), 1)
        )
    }

    private fun question1(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_forma_circulo),
            Alternative(2, R.drawable.ic_forma_quadrado),
            Alternative(3, R.drawable.ic_forma_triangulo),
            Alternative(4, 0)
        )
    }

    private fun question2(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_forma_coracao),
            Alternative(2, R.drawable.ic_forma_triangulo),
            Alternative(3, R.drawable.ic_forma_circulo),
            Alternative(4, 0)
        )
    }

    private fun question3(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_forma_triangulo),
            Alternative(2, R.drawable.ic_forma_estrela),
            Alternative(3, R.drawable.ic_forma_quadrado),
            Alternative(4, 0)
        )
    }

    private fun question4(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_forma_circulo),
            Alternative(2, R.drawable.ic_forma_triangulo),
            Alternative(3, R.drawable.ic_forma_coracao),
            Alternative(4, 0)
        )
    }

    private fun question5(): List<Alternative> {
        return listOf(
            Alternative(1, R.drawable.ic_forma_quadrado),
            Alternative(2, R.drawable.ic_forma_estrela),
            Alternative(3, R.drawable.ic_forma_circulo),
            Alternative(4, 0)
        )
    }

    private fun question6(): List<Alternative> {
        return listOf(
            Alternative(1,  R.drawable.ic_forma_quadrado),
            Alternative(2, R.drawable.ic_forma_circulo),
            Alternative(3, R.drawable.ic_forma_estrela),
            Alternative(4, 0)
        )
    }
}