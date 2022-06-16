package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.local.TestNumeric
import com.example.appcolorblindness.data.models.QuestionResponse
import com.example.appcolorblindness.databinding.FragmentTestNumberBinding

class TestNumberFragment : Fragment() {
    private lateinit var binding: FragmentTestNumberBinding
    private var count = 0
    private var listResponseQuestions: MutableList<QuestionResponse> = mutableListOf()
    private var testNumeric = TestNumeric().test


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestNumberBinding.inflate(inflater, container, false)
        loadQuestion()
        mapClick()
        navigationOfTestNumber()
        return binding.root
    }

    private fun mapClick() {
        binding.mcAlternativa1.setOnClickListener {
            responseQuestion(1)
        }

        binding.mcAlternativa2.setOnClickListener {
            responseQuestion(2)
        }

        binding.mcAlternativa3.setOnClickListener {
            responseQuestion(3)
        }

        binding.mcNenhumaAlternativa.setOnClickListener {
            responseQuestion(4)
        }
    }

    private fun loadQuestion() {
        val question = testNumeric.listQuestion[count]
        binding.ivImagemDoTeste.setImageResource(question.imageResourceId)
        binding.tvAlternativa1.text = question.listAlternative[0].valueAlternative.toString()
        binding.tvAlternativa2.text = question.listAlternative[1].valueAlternative.toString()
        binding.tvAlternativa3.text = question.listAlternative[2].valueAlternative.toString()
    }


    private fun responseQuestion(selectedAlternative: Int) {
        count++

        listResponseQuestions.add(QuestionResponse(count, selectedAlternative))

        if (count == 10) {
            count = 0
            finishTest()
            return
        }
        loadQuestion()
    }

    private fun finishTest() {
        val questions = testNumeric.listQuestion
        val responses = listResponseQuestions
        var correctResponse = 0
        responses.forEach {
            val question = questions[it.questionId - 1]
            if(question.correctAlternative == it.selectedAlternative) correctResponse++
        }
        Toast.makeText(requireContext(), "Você acertou $correctResponse de ${questions.size} testes", Toast.LENGTH_SHORT).show()
    }

    private fun navigationOfTestNumber() {
        binding.ibArrowBackTestNumber.setOnClickListener {
            findNavController().navigate(R.id.action_fragTestNumber_to_fragChooseGame)
        }
    }
}