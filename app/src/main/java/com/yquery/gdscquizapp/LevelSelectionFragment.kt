package com.yquery.gdscquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.slider.Slider
import com.warkiz.tickseekbar.OnSeekChangeListener
import com.warkiz.tickseekbar.SeekParams
import com.warkiz.tickseekbar.TickSeekBar
import com.yquery.gdscquizapp.databinding.FragmentLevelSelectionBinding

class LevelSelectionFragment : Fragment() {

    private var numberOfQuestions = 1

    private var _binding : FragmentLevelSelectionBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            Toast.makeText(activity, it.getString("name"), Toast.LENGTH_SHORT).show()
            activity?.title = "Welcome ${it.getString("name")}"

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLevelSelectionBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        binding.choose.setOnClickListener {
            val bottomSheet = BottomSheetDialog(requireContext())

            bottomSheet.setContentView(R.layout.bottom_sheet_layout)

            val slider = bottomSheet.findViewById<TickSeekBar>(R.id.slider)
            val openButton = bottomSheet.findViewById<MaterialButton>(R.id.open_quiz_button)

            slider!!.onSeekChangeListener = object : OnSeekChangeListener{
                override fun onSeeking(seekParams: SeekParams?) {
//                    Toast.makeText(activity, seekParams!!.progress.toString(), Toast.LENGTH_SHORT).show()
                }

                override fun onStartTrackingTouch(seekBar: TickSeekBar?) {
                }

                override fun onStopTrackingTouch(seekBar: TickSeekBar?) {
//                    Toast.makeText(activity, "Done ${seekBar!!.progress}", Toast.LENGTH_SHORT).show()
                    numberOfQuestions = seekBar!!.progress

                }

            }

            openButton!!.setOnClickListener {
//                Toast.makeText(activity, numberOfQuestions.toString(), Toast.LENGTH_SHORT).show()
                bottomSheet.dismiss()

                findNavController().navigate(
                    LevelSelectionFragmentDirections.actionLevelSelectionFragmentToQuizFragment(
                        numberOfQuestions
                    )
                )
            }

            bottomSheet.show()
        }

        return root
    }

}