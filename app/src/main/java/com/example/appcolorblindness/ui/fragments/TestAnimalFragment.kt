package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appcolorblindness.databinding.FragmentAnimalTestBinding

class TestAnimalFragment : Fragment() {
    private lateinit var binding: FragmentAnimalTestBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimalTestBinding.inflate(inflater, container, false)

        return binding.root
    }
}