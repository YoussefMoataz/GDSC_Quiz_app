package com.yquery.gdscquizapp

import com.yquery.gdscquizapp.models.Question

class Questions {

    val list : ArrayList<Question> = arrayListOf(
        Question(1, "What is the color of Mcdonald's logo ?", "red", "yellow", "black", "green", 2),
        Question(2, "What is the instructor's name ?", "Ahmed", "Youssef", "Seif", "Amr", 3),
        Question(3, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(4, "What is the color of pepsi's logo ? 2", "blue", "yellow", "black", "green", 1),
        Question(5, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(6, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(7, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(8, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(9, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(10, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(11, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(12, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(13, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(14, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(15, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1)
    )

    fun getTheList() : ArrayList<Question>{
        return list
    }

}