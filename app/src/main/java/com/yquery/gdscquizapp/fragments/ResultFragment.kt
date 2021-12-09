package com.yquery.gdscquizapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yquery.gdscquizapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    var score: Int = 0
    var num_of_questions: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            score = it.getInt("score")
            num_of_questions = it.getInt("num_of_questions")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        binding.resultTextview.setText("You got $score out of $num_of_questions")

        if (num_of_questions % 2 == 0) {
            if (score >= num_of_questions / 2) {
                binding.congratsLottie.playAnimation()
            } else {
                binding.congratsLottie.visibility = View.GONE
            }
        } else {
            if (score > num_of_questions / 2) {
                binding.congratsLottie.playAnimation()
            } else {
                binding.congratsLottie.visibility = View.GONE
            }
        }

        return root
    }
}