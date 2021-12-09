package com.yquery.gdscquizapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.yquery.gdscquizapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        val root = binding.root

        binding.loginButton.setOnClickListener {

            val name = binding.nameInput.text.toString()

            if (name.isNotBlank()) {
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToLevelSelectionFragment(
                        name
                    )
                )
            }else{
                binding.nameInputLayout.error = "Please enter your name"
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}