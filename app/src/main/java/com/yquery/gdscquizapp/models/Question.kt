package com.yquery.gdscquizapp.models

data class Question(
    val number: Int,
    val question: String,
    val answer1: String,
    val answer2: String,
    val answer3: String,
    val answer4: String,
    val correctAnswer: Int,
)
