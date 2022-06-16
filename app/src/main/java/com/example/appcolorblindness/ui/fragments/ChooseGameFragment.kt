package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.data.preferences.ColorBlindnessData
import com.example.appcolorblindness.data.helpers.fromatters.ColorBlindnessFormatter
import com.example.appcolorblindness.databinding.FragmentChooseGameBinding
import com.example.appcolorblindness.ui.viewmodels.ColorBlindnessViewModel

class ChooseGameFragment : Fragment() {
    private lateinit var binding: FragmentChooseGameBinding
    private val viewModel: ColorBlindnessViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseGameBinding.inflate(inflater, container, false)

        navigationOfChooseGame()
        checkIfItIs5YearsOld()
        setUsername()

        return binding.root
    }

    private fun navigationOfChooseGame() {
        binding.ibArrowBackChooseGame.setOnClickListener {
            findNavController().navigate(R.id.action_fragChooseGame_to_fragAgeGroup)
        }

        binding.ibBtnTestNumbers.setOnClickListener {
            findNavController().navigate(R.id.action_fragChooseGame_to_fragTestNumber)
        }

        binding.ibBtnTestAnimals.setOnClickListener {
            findNavController().navigate(R.id.action_fragChooseGame_to_fragTestAnimal)
        }

        binding.ibBtnTestGeometrics.setOnClickListener {
            findNavController().navigate(R.id.action_fragChooseGame_to_fragTestGeometricShapes)
        }
    }

    private fun checkIfItIs5YearsOld() {
        val data = arguments?.getString("FIVE_YEARS")
        if (data != null) {
            binding.ibBtnTestNumbers.visibility = View.GONE
        } else {
            binding.ibBtnTestNumbers.visibility = View.VISIBLE
        }
    }

    private fun setUsername() {
        val name = ColorBlindnessData.readUsername(requireContext())
        binding.tvUsername.text = ColorBlindnessFormatter.formatUsername(name)
    }
}