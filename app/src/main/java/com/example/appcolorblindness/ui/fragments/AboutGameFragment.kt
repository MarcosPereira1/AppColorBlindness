package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appcolorblindness.databinding.FragmentAboutGameBinding


class AboutGameFragment : Fragment() {
    private lateinit var binding: FragmentAboutGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutGameBinding.inflate(inflater, container, false)

        return binding.root
    }
}