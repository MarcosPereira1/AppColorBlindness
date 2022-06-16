package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.databinding.FragmentTestAnimalBinding

class TestAnimalFragment : Fragment() {
    private lateinit var binding: FragmentTestAnimalBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestAnimalBinding.inflate(inflater, container, false)
        navigationOfTestAnimal()

        return binding.root
    }

    private fun navigationOfTestAnimal() {
        binding.ibArrowBackTestNumber.setOnClickListener {
            findNavController().navigate(R.id.action_fragTestAnimal_to_fragChooseGame)
        }
    }
}