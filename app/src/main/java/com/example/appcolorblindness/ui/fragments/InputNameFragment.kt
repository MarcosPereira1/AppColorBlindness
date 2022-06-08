package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.databinding.FragmentInputNameBinding

class InputNameFragment : Fragment() {
    private lateinit var binding: FragmentInputNameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputNameBinding.inflate(inflater, container, false)
        navigateToAgeGroup()

        return binding.root
    }

    private fun navigateToAgeGroup() {
        binding.ibNext.setOnClickListener {
            findNavController().navigate(R.id.action_fragInputName_to_fragAgeGroup)
        }

        binding.ibArrowBack.setOnClickListener {
            findNavController().navigate(R.id.action_fragInputName_to_fragStartGame)
        }
    }
}