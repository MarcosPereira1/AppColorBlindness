package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.databinding.FragmentAboutGameBinding


class AboutGameFragment : Fragment() {
    private lateinit var binding: FragmentAboutGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAboutGameBinding.inflate(inflater, container, false)

        navigateToStartGame()
        return binding.root
    }

    fun navigateToStartGame() {
        binding.ibArrow.setOnClickListener {
            findNavController().navigate(R.id.action_fragAboutGame_to_fragStartGame)
        }
    }
}