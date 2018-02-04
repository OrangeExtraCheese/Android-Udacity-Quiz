package com.android.udacity.androidquiz2;

/**
 * Created by Admin on 2018-02-03.
 */

class SingleChoiceQuestion extends Question
{
    private String answerA, answerB, answerC, answerD;


//CONSTRUCTOR ASSIGNS VALUES FROM ATTRIBUTE (STRING ARRAY FORMED FROM XML STRING-ARRAY STORING QUESTION STRINGS) TO QUESTION, ANSWERS AND CORRECT ANSWER
    public SingleChoiceQuestion(String[] questionXML)
    {
        this.question = questionXML[0];
        this.answerA = questionXML[1];
        this.answerB = questionXML[2];
        this.answerC = questionXML[3];
        this.answerD = questionXML[4];
        this.correctAnswer = questionXML[5];
    }

    public String getAnswerA() {
        return answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public String getAnswerD() {
        return answerD;
    }
}
