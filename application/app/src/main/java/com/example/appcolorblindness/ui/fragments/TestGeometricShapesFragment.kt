package com.example.appcolorblindness.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.constants.ColorBlindnessConstants
import com.example.appcolorblindness.data.local.TestGeometricsShapes
import com.example.appcolorblindness.data.models.QuestionResponse
import com.example.appcolorblindness.data.preferences.ColorBlindnessData
import com.example.appcolorblindness.databinding.FragmentTestGeometricShapesBinding

class TestGeometricShapesFragment : Fragment() {
    private lateinit var binding: FragmentTestGeometricShapesBinding
    private var count = 0
    private var listResponseQuestions: MutableList<QuestionResponse> = mutableListOf()
    private var testGeometricShapes = TestGeometricsShapes().test
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestGeometricShapesBinding.inflate(inflater, container, false)
        loadQuestion()
        mapClick()
        navigationOfTestGeometrics()

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
        val question = testGeometricShapes.listQuestion[count]
        binding.ivImagemDoTeste.setImageResource(question.imageResourceId)
        binding.ivAlternative1.setImageResource(question.listAlternative[0].valueAlternative)
        binding.ivAlternative2.setImageResource(question.listAlternative[1].valueAlternative)
        binding.ivAlternative3.setImageResource(question.listAlternative[2].valueAlternative)
    }


    private fun responseQuestion(selectedAlternative: Int) {
        // val question = testAnimal.listQuestion[count]
        count++
        listResponseQuestions.add(QuestionResponse(count, selectedAlternative))
        // Toast.makeText(requireContext(), "Certa: ${question.correctAlternative}, escolha: $selectedAlternative", Toast.LENGTH_SHORT).show()

        if (count == 6) {
            count = 0
            finishTest()
            return
        }
        loadQuestion()
    }

    private fun finishTest() {
        val questions = testGeometricShapes.listQuestion
        val responses = listResponseQuestions
        var correctResponse = 0
        responses.forEach {
            val question = questions[it.questionId - 1]
            if(question.correctAlternative == it.selectedAlternative) correctResponse++
        }

        if (correctResponse >= 4) {
            val data = bundleOf(ColorBlindnessConstants.RESPONSE_USER to "$correctResponse")
            ColorBlindnessData.writeCorrectResponse(requireContext(), correctResponse)
            findNavController().navigate(R.id.action_fragTestGeometricShapes_to_fragFeedbackOk, data)

        } else {
            val data = bundleOf(ColorBlindnessConstants.RESPONSE_USER to "$correctResponse")
            findNavController().navigate(R.id.action_fragTestGeometricShapes_to_fragFeedbackFail, data)
        }

        ColorBlindnessData.writeQuestions(requireContext(), questions.size)
    }

    private fun navigationOfTestGeometrics() {
        binding.ibArrowBackTestNumber.setOnClickListener {
            confirmExitTest()
        }
    }

    private fun confirmExitTest() {
        val builder = AlertDialog.Builder(context)
        builder.setMessage("Tem certeza que desistir do teste?")
            .setCancelable(false)
            .setPositiveButton(
                "Sim"
            ) { _, _ ->
                findNavController().navigate(R.id.action_fragTestGeometricShapes_to_fragAgeGroup) }
            .setNegativeButton(
                "Não"
            ) { dialog, _ -> dialog.cancel() }
        val alert = builder.create()
        alert.show()
    }
}