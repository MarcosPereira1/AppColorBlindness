package com.example.appcolorblindness.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.appcolorblindness.R
import com.example.appcolorblindness.databinding.FragmentStartGameBinding

class StartGameFragment: Fragment() {
    private lateinit var binding: FragmentStartGameBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartGameBinding.inflate(inflater, container, false)

        navigateToInputName()
        return binding.root
    }

    private fun navigateToInputName() {
        binding.ibPlay.setOnClickListener {
            findNavController().navigate(R.id.action_fragStartGame_to_fragInputName)
        }
    }
}