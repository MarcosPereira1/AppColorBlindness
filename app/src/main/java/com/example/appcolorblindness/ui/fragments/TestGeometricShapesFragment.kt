package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.databinding.FragmentTestGeometricShapesBinding

class TestGeometricShapesFragment : Fragment() {
    private lateinit var binding: FragmentTestGeometricShapesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestGeometricShapesBinding.inflate(inflater, container, false)
        navigationOfTestGeometrics()

        return binding.root
    }

    private fun navigationOfTestGeometrics() {
        binding.ibArrowBackTestNumber.setOnClickListener {
            findNavController().navigate(R.id.action_fragTestGeometricShapes_to_fragChooseGame)
        }
    }
}