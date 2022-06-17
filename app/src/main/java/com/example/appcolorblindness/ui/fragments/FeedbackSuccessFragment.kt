package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.constants.ColorBlindnessConstants
import com.example.appcolorblindness.data.preferences.ColorBlindnessData
import com.example.appcolorblindness.databinding.FragmentFeedbackOkBinding


class FeedbackSuccessFragment : Fragment() {
    private lateinit var binding: FragmentFeedbackOkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFeedbackOkBinding.inflate(inflater, container, false)
        navigationToChooseGame()
        setResultTest()
        return binding.root
    }

    private fun navigationToChooseGame() {
        binding.ibArrowBackChooseGame.setOnClickListener {
            findNavController().navigate(R.id.action_fragFeedbackOk_to_fragChooseGame)
        }
    }

    private fun setResultTest() {
        val response = arguments?.getString(ColorBlindnessConstants.RESPONSE_USER)
        ColorBlindnessData.readCorrectQuestions(requireContext())
        val feedback = "Você acertou $response de ${ColorBlindnessData.readQuestions(requireContext())} testes"
        binding.tvFeedback.text = feedback
    }
}