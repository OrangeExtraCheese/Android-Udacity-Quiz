package com.android.udacity.androidquiz2;

/**
 * Created by Admin on 2018-02-03.
 */

class MultipleChoiceQuestion extends Question
{

    private String answerA, answerB, answerC, answerD;
    private String[] correctAnswers;

    //CONSTRUCTOR ASSIGNS VALUES FROM ATTRIBUTE (STRING ARRAY FORMED FROM XML STRING-ARRAY STORING QUESTION STRINGS) TO QUESTION, ANSWERS AND CORRECT ANSWER
    public MultipleChoiceQuestion(String[] questionXML, String[] answersXML)
    {
        this.question = questionXML[0];
        this.answerA = questionXML[1];
        this.answerB = questionXML[2];
        this.answerC = questionXML[3];
        this.answerD = questionXML[4];
        this.correctAnswers = answersXML; //The difference from SingleChoiceQuestion class constructor is that correct answer is not a single String but an array of Strings
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

    public String[] getCorrectAnswers() {
        return correctAnswers;
    }
}
