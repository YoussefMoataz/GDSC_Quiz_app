package com.yquery.gdscquizapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yquery.gdscquizapp.Questions
import com.yquery.gdscquizapp.R
import com.yquery.gdscquizapp.databinding.FragmentQuizBinding
import com.yquery.gdscquizapp.models.Question

class QuizFragment : Fragment() {

    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!

    lateinit var questions: ArrayList<Question>
    var userAnswers: ArrayList<Int> = arrayListOf()

    var questionNumber: Int = 1

    var answerSelected = false

    var currentAnswer = 0

    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            Toast.makeText(
//                activity,
//                it.getInt("number_of_questions").toString(),
//                Toast.LENGTH_SHORT
//            ).show()

            activity?.title = "Quiz time"

            questions = addQuestions(it.getInt("number_of_questions"))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuizBinding.inflate(layoutInflater, container, false)
        val root = binding.root

        setViews(questionNumber)

        binding.progressBar.max = questions.size

        binding.nextQuestion.setOnClickListener {
            if (answerSelected) {
                nextQuestion(currentAnswer)
            }
        }

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.first_answer -> currentAnswer = 1
                R.id.second_answer -> currentAnswer = 2
                R.id.third_answer -> currentAnswer = 3
                R.id.fourth_answer -> currentAnswer = 4
            }
            answerSelected = true

//            Toast.makeText(activity, currentAnswer.toString(), Toast.LENGTH_SHORT).show()
        }

        return root
    }

    fun addQuestions(number: Int): ArrayList<Question> {

        val questionList = arrayListOf<Question>()
        val allQuestions = Questions().getTheList()

        var i = 0

        while (i < number) {
            questionList.add(allQuestions[i])
            i += 1
        }

        return questionList
    }

    private fun setViews(questionNumber: Int) {

        val currentQuestion = questions[questionNumber - 1]

        binding.questionTextview.text = currentQuestion.question

        binding.firstAnswer.isChecked = false
        binding.secondAnswer.isChecked = false
        binding.thirdAnswer.isChecked = false
        binding.fourthAnswer.isChecked = false

        binding.firstAnswer.text = currentQuestion.answer1
        binding.secondAnswer.text = currentQuestion.answer2
        binding.thirdAnswer.text = currentQuestion.answer3
        binding.fourthAnswer.text = currentQuestion.answer4

        binding.progressBar.progress += 1

    }

    private fun nextQuestion(currentAnswer: Int) {

        if (questionNumber < questions.size) {

            userAnswers.add(currentAnswer)

            questionNumber += 1
            setViews(questionNumber)

        } else {

            userAnswers.add(currentAnswer)
            submitAnswers()
        }
        answerSelected = false
    }

    private fun submitAnswers() {

        var counter = 0

        while (counter < userAnswers.size) {

            if (userAnswers[counter] == questions[counter].correctAnswer) {
                score += 1
            }

            counter += 1
        }

        findNavController().navigate(
            QuizFragmentDirections.actionQuizFragmentToResultFragment(score, questions.size)
        )

    }

}