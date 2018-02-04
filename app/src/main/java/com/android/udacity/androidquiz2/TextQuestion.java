package com.android.udacity.androidquiz2;

/**
 * Created by Admin on 2018-02-03.
 */

class TextQuestion extends Question
{
    public TextQuestion(String[] questionXML)
    {
        this.question = questionXML[0];
        this.correctAnswer = questionXML[1];
    }
}
