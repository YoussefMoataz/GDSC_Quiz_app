package com.yquery.gdscquizapp

import com.yquery.gdscquizapp.models.Question

class Questions {

    val list : ArrayList<Question> = arrayListOf(
        Question(1, "What is the color of Mcdonald's logo ?", "red", "yellow", "black", "green", 2),
        Question(2, "What is the instructor's name ?", "Ahmed", "Youssef", "Seif", "Amr", 3),
        Question(3, "What is the color of pepsi's logo ?", "blue", "yellow", "black", "green", 1),
        Question(4, "Where is Egypt ?", "Asia", "Europe", "Africa", "North America", 3),
        Question(5, "What is Android's main programming language ?", "HTML", "Kotlin", "PHP", "Swift", 2),
        Question(6, "What is the color of chocolate ?", "blue", "yellow", "brown", "green", 3),
        Question(7, "What to do next ?", "Read only", "Practice a lot", "Do nothing", "Other", 2),
        Question(8, "What is the color of coca cola's logo ?", "red", "yellow", "black", "green", 1),
        Question(9, "What is the color of blood ?", "blue", "red", "black", "green", 2),
        Question(10, "What is the color of samsung's logo ?", "orange", "yellow", "black", "blue", 4),
        Question(11, "What is hot ?", "ice cream", "tea", "smoothie", "milkshake", 2),
        Question(12, "What is my name ?", "Ahmed", "Youssef", "Seif", "Amr", 2),
        Question(13, "What is the color of pepsi's logo again ?", "blue", "yellow", "black", "green", 1),
        Question(14, "What is the not a device ?", "printer", "mobile", "paper", "television", 3),
        Question(15, "Bonus :\nWhich one should we thank ?", "Eng Seif", "Eng Seif", "Eng Seif", "Eng Seif", 1)
    )

    fun getTheList() : ArrayList<Question>{
        return list
    }

}