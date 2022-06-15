package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.constants.ColorBlindnessConstants
import com.example.appcolorblindness.databinding.FragmentAgeGroupBinding
import com.example.appcolorblindness.ui.viewmodels.ColorBlindnessViewModel

class AgeGroupFragment : Fragment() {
    private lateinit var binding: FragmentAgeGroupBinding
    private val viewModel: ColorBlindnessViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgeGroupBinding.inflate(inflater, container, false)
        chooseAgeGroup()
        navigateToAgeGroup()

        return binding.root
    }

    private fun navigateToAgeGroup() {
        binding.ibArrowBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragAgeGroup_to_fragInputName)
        }
    }

    private fun chooseAgeGroup() {
        binding.btn2a5anos.setOnClickListener {
            val data = bundleOf(ColorBlindnessConstants.FIVE_YEARS to "fiveYears")
            findNavController().navigate(R.id.action_fragAgeGroup_to_fragChooseGame, data)
        }

        binding.btn6ouMais.setOnClickListener {
            findNavController().navigate(R.id.action_fragAgeGroup_to_fragChooseGame)
        }

    }
}