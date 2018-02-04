package com.android.udacity.androidquiz2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity

{
    RadioButton singleChoiceQuestion1Checked;
    RadioButton singleChoiceQuestion2Checked;

    CheckBox multipleChoiceQuestion1A;
    CheckBox multipleChoiceQuestion1B;
    CheckBox multipleChoiceQuestion1C;
    CheckBox multipleChoiceQuestion1D;

    EditText textQuestionAnswer1;

    SingleChoiceQuestion[] SingleChoiceQuestionPoll;
    MultipleChoiceQuestion[] MultipleChoiceQuestionPoll;
    TextQuestion[] TextQuestionPoll;
    int[] drawnSingleChoiceQuestions;
    int[] drawnMultipleChoiceQuestions;
    int[] drawnTextQuestions;

    Random randomGenerator = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //LISTENER IS APPLIED TO RadioGroup, SO WHENEVER USER CHANGES SELECTION IN THIS RADIO GROUP, singleChoiceQuestion<number>Checked IS REFERENCING CURRENCTLY SELECTED RADIO BUTTON
        RadioGroup singleQuestion1Answers = (RadioGroup)findViewById(R.id.singleChoiceQuestion1Answers);
        singleQuestion1Answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()

        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                 singleChoiceQuestion1Checked = (RadioButton)group.findViewById(checkedId);
            }
        });

        RadioGroup singleQuestion2Answers = (RadioGroup)findViewById(R.id.singleChoiceQuestion2Answers);
        singleQuestion2Answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                singleChoiceQuestion2Checked = (RadioButton)group.findViewById(checkedId);
            }
        });

        //#########################CREATE QUESTION OBJECTS HERE###########################
        //NEW OBJECTS REPRESENTING QUESTIONS OF SINGLE CHOICE TYPE, ONE OBJECT FOR ONE QUESTION DEFINED AS STRING-ARRAY IN strings.xml RESOURCE
        SingleChoiceQuestion singleChoiceQuestion1 = new SingleChoiceQuestion(getResources().getStringArray(R.array.singleChoiceQuestion1));
        SingleChoiceQuestion singleChoiceQuestion2 = new SingleChoiceQuestion(getResources().getStringArray(R.array.singleChoiceQuestion2));
        SingleChoiceQuestion singleChoiceQuestion3 = new SingleChoiceQuestion(getResources().getStringArray(R.array.singleChoiceQuestion3));
        SingleChoiceQuestion singleChoiceQuestion4 = new SingleChoiceQuestion(getResources().getStringArray(R.array.singleChoiceQuestion4));


        //NEW OBJECTS REPRESENTING QUESTIONS OF MULTIPLE CHOICE TYPE, ONE OBJECT FOR ONE QUESTION DEFINED AS STRING-ARRAY IN strings.xml RESOURCE
        MultipleChoiceQuestion multipleChoiceQuestion1 = new MultipleChoiceQuestion(getResources().getStringArray(R.array.multipleChoiceQuestion1),
                getResources().getStringArray(R.array.multipleChoiceQuestion1Answers)
        );

        MultipleChoiceQuestion multipleChoiceQuestion2 = new MultipleChoiceQuestion(getResources().getStringArray(R.array.multipleChoiceQuestion2),
                getResources().getStringArray(R.array.multipleChoiceQuestion2Answer)
        );

        MultipleChoiceQuestion multipleChoiceQuestion3 = new MultipleChoiceQuestion(getResources().getStringArray(R.array.multipleChoiceQuestion3),
                getResources().getStringArray(R.array.multipleChoiceQuestion3Answer)
        );

        //NEW OBJECTS REPRESENTING QUESTIONS OF OPEN TYPE, ONE OBJECT FOR ONE QUESTION DEFINED AS STRING-ARRAY IN strings.xml RESOURCE
        TextQuestion textQuestion1 = new TextQuestion(getResources().getStringArray(R.array.openQuestion1));
        TextQuestion textQuestion2 = new TextQuestion(getResources().getStringArray(R.array.openQuestion2));
        //###################################################################################

        //#########################PUT CREATED OBJECTS TO ARRAY OF CORRESPONDING TYPE###########################
        //OBJECTS REPRESENTING QUESTIONS OF SINGLE CHOICE TYPE ARE STORED IN SingleChoiceQuestionPoll ARRAY, STARTING FROM INDEX 1
        SingleChoiceQuestionPoll = new SingleChoiceQuestion[20];
        SingleChoiceQuestionPoll[1] = singleChoiceQuestion1;
        SingleChoiceQuestionPoll[2] = singleChoiceQuestion2;
        SingleChoiceQuestionPoll[3] = singleChoiceQuestion3;
        SingleChoiceQuestionPoll[4] = singleChoiceQuestion4;

        //OBJECTS REPRESENTING QUESTIONS OF MULTIPLE CHOICE TYPE ARE STORED IN MultipleChoiceQuestionPoll ARRAY, STARTING FROM INDEX 1
        MultipleChoiceQuestionPoll = new MultipleChoiceQuestion[20];
        MultipleChoiceQuestionPoll[1] = multipleChoiceQuestion1;
        MultipleChoiceQuestionPoll[2] = multipleChoiceQuestion2;
        MultipleChoiceQuestionPoll[3] = multipleChoiceQuestion3;

        //OBJECTS REPRESENTING QUESTIONS OF OPEN TYPE ARE STORED IN TextQuestionPoll ARRAY, STARTING FROM INDEX 1
        TextQuestionPoll = new TextQuestion[20];
        TextQuestionPoll[1] = textQuestion1;
        TextQuestionPoll[2] = textQuestion2;

//###############################################################################################################

        //OBJECTS REPRESENTING ANSWER UI ELEMENTS FOR QUESTIONS OF MULTIPLE CHOICE
        multipleChoiceQuestion1A = (CheckBox) findViewById(R.id.multipleChoiceQuestion1AnswerA);
        multipleChoiceQuestion1B = (CheckBox) findViewById(R.id.multipleChoiceQuestion1AnswerB);
        multipleChoiceQuestion1C = (CheckBox) findViewById(R.id.multipleChoiceQuestion1AnswerC);
        multipleChoiceQuestion1D = (CheckBox) findViewById(R.id.multipleChoiceQuestion1AnswerD);

        //OBJECTS REPRESENTING ANSWER UI ELEMENTS FOR QUESTIONS OF OPEN CHOICE
        textQuestionAnswer1 = (EditText) findViewById(R.id.openQuestion1Answer);

        drawQuiz();

    }

    private void drawQuiz()
    {
        //GETS ARRAY OF RANDOMLY GENERATED NUMBERS OF QUESTIONS
        drawnSingleChoiceQuestions = generateIntArray(2, 4, randomGenerator);

        //RANDOMLY GENERATED NUMBER IS USED AS INDEX FOR ARRAY OF QUESTIONS,QUESTION OBJECT RESIDING AT THIS INDEX IS PASSED AS AN ARGUMENT, PASSED ARE ALSO TEXT VIEWS FOR WHICH QUESTION OBJECT VALUES WILL BE APPLIED
        displaySingleChoiceQuestion(SingleChoiceQuestionPoll[drawnSingleChoiceQuestions[0]],
                (TextView) findViewById(R.id.singleChoiceQuestion1),
                (TextView) findViewById(R.id.singleChoiceQuestion1AnswerA),
                (TextView) findViewById(R.id.singleChoiceQuestion1AnswerB),
                (TextView) findViewById(R.id.singleChoiceQuestion1AnswerC),
                (TextView) findViewById(R.id.singleChoiceQuestion1AnswerD)
        );

        displaySingleChoiceQuestion(SingleChoiceQuestionPoll[drawnSingleChoiceQuestions[1]],
                (TextView) findViewById(R.id.singleChoiceQuestion2),
                (TextView) findViewById(R.id.singleChoiceQuestion2AnswerA),
                (TextView) findViewById(R.id.singleChoiceQuestion2AnswerB),
                (TextView) findViewById(R.id.singleChoiceQuestion2AnswerC),
                (TextView) findViewById(R.id.singleChoiceQuestion2AnswerD)
        );

        drawnMultipleChoiceQuestions = generateIntArray(1, 3, randomGenerator);

        displayMultipleChoiceQuestion(MultipleChoiceQuestionPoll[drawnMultipleChoiceQuestions[0]],
                (TextView) findViewById(R.id.multipleChoiceQuestion1),
                (TextView) findViewById(R.id.multipleChoiceQuestion1AnswerA),
                (TextView) findViewById(R.id.multipleChoiceQuestion1AnswerB),
                (TextView) findViewById(R.id.multipleChoiceQuestion1AnswerC),
                (TextView) findViewById(R.id.multipleChoiceQuestion1AnswerD)
        );

        drawnTextQuestions = generateIntArray(1, 2, randomGenerator);
        displayTextQuestion(TextQuestionPoll[drawnTextQuestions[0]], (TextView) findViewById(R.id.openQuestion1));
    }

    //GETS STRING VALUES OF CHOICE QUESTION AND ANSWERS AND PASSES THEM TO setText() METHOD TO DISPLAY QUESTION AND ANSWERS TO USER
    private void displaySingleChoiceQuestion(SingleChoiceQuestion source, TextView question, TextView answer1, TextView answer2, TextView answer3, TextView answer4)
    {
        question.setText(source.getQuestion());
        answer1.setText(source.getAnswerA());
        answer2.setText(source.getAnswerB());
        answer3.setText(source.getAnswerC());
        answer4.setText(source.getAnswerD());
    }

    //GETS STRING VALUES OF CHOICE QUESTION AND ANSWERS AND PASSES THEM TO setText() METHOD TO DISPLAY QUESTION AND ANSWERS TO USER
    private void displayMultipleChoiceQuestion(MultipleChoiceQuestion source, TextView question, TextView answer1, TextView answer2, TextView answer3, TextView answer4)
    {
        question.setText(source.getQuestion());
        answer1.setText(source.getAnswerA());
        answer2.setText(source.getAnswerB());
        answer3.setText(source.getAnswerC());
        answer4.setText(source.getAnswerD());
    }

    //GETS STRING VALUE OF OPEN QUESTION AND PASSES IT TO setText() METHOD TO DISPLAY QUESTION TO USER
    private void displayTextQuestion(TextQuestion source, TextView question)
    {
        question.setText(source.getQuestion());
    }

    //COMPARES USER ANSWERS WITH CORRECT ONES AND INCREASES POINTS COUNTER IN CASE OF EQUALITY
    public void finishQuiz(View view)
    {
        int score = 0;

        if(singleChoiceQuestion1Checked!=null)
        {
            if(checkSingleChoice(SingleChoiceQuestionPoll[drawnSingleChoiceQuestions[0]], singleChoiceQuestion1Checked))
                score++;
        }
        if(singleChoiceQuestion2Checked!=null)
        {
            if(checkSingleChoice(SingleChoiceQuestionPoll[drawnSingleChoiceQuestions[1]], singleChoiceQuestion2Checked))
                score++;
        }
        if(checkMultipleChoice(MultipleChoiceQuestionPoll[drawnMultipleChoiceQuestions[0]], multipleChoiceQuestion1A, multipleChoiceQuestion1B, multipleChoiceQuestion1C, multipleChoiceQuestion1D))
            score++;
        if(checkText(TextQuestionPoll[drawnTextQuestions[0]], textQuestionAnswer1))
            score++;

            Toast.makeText(getApplicationContext(),"Your score is "+score,Toast.LENGTH_SHORT).show();
        if(score>=3)
        {
            TextView scoreView = (TextView) findViewById(R.id.score);
            scoreView.setText(getResources().getString(R.string.testPassed));
        }
        else
        {
            TextView scoreView = (TextView) findViewById(R.id.score);
            scoreView.setText(getResources().getString(R.string.testFailed));
        }
    }

    public void resetQuiz(View view)
    {
        drawQuiz();
    }

    private boolean checkSingleChoice(SingleChoiceQuestion source , RadioButton answer)
    {
        return answer.getText().toString().equals(source.getCorrectAnswer());
    }

    //CHECKS IF TEXTS OF CHECKBOXES MARKED BY USER MATCH CORRECT ANSWERS STORED IN STRING ARRAY OF CORRECT ANSWERS (THIS ARRAY IS STORED IN OBJECT OF QUESTION)
    private boolean checkMultipleChoice(MultipleChoiceQuestion question , CheckBox answerA, CheckBox answerB, CheckBox answerC, CheckBox answerD)
    {
        boolean correct = false;

        if(answerA.isChecked()&&checkIfInStringArray(question.getCorrectAnswers() ,answerA.getText().toString()))
             correct = true;
        if(!(answerA.isChecked())&&checkIfInStringArray(question.getCorrectAnswers() ,answerA.getText().toString()))
            return false;
        if(answerA.isChecked()&&!(checkIfInStringArray(question.getCorrectAnswers() ,answerA.getText().toString())))
            return false;
        if(answerB.isChecked()&&checkIfInStringArray(question.getCorrectAnswers() ,answerB.getText().toString()))
            correct = true;
        if(!(answerB.isChecked())&&checkIfInStringArray(question.getCorrectAnswers() ,answerB.getText().toString()))
            return false;
        if(answerB.isChecked()&&!(checkIfInStringArray(question.getCorrectAnswers() ,answerB.getText().toString())))
            return false;
        if(answerC.isChecked()&&checkIfInStringArray(question.getCorrectAnswers() ,answerC.getText().toString()))
            correct = true;
        if(!(answerC.isChecked())&&checkIfInStringArray(question.getCorrectAnswers() ,answerC.getText().toString()))
            return false;
        if(answerC.isChecked()&&!(checkIfInStringArray(question.getCorrectAnswers() ,answerC.getText().toString())))
            return false;
        if(answerD.isChecked()&&checkIfInStringArray(question.getCorrectAnswers() ,answerD.getText().toString()))
            correct = true;
        if(!(answerD.isChecked())&&checkIfInStringArray(question.getCorrectAnswers() ,answerD.getText().toString()))
            return false;
        if(answerD.isChecked()&&!(checkIfInStringArray(question.getCorrectAnswers() ,answerD.getText().toString())))
            return false;

        return correct;
    }

    private boolean checkText(TextQuestion question, EditText answer)
    {
                return question.getCorrectAnswer().equals(answer.getText().toString());
    }

    //RETURN ARRAY OF UNIQUE INTEGERS
    private int[] generateIntArray(int size, int range, Random randomGenerator)
    {
        int[] integers = new int[size];
        int generatedNumber;

        for(int i = 0; i < size; i++)
        {
            generatedNumber=randomGenerator.nextInt((range - 1) + 1) + 1; // To generate random integer in range (closed interval): int randomNum = rand.nextInt((max - min) + 1) + min;
            if(!checkIfInIntegerArray(integers, generatedNumber))
                integers[i]=generatedNumber;
            else
            {
                i--;  //If randomly generated number is already in an array, the loop counter is decreased, so current iteration of loop is omitted
            }
        }
        return integers;
    }

    //CHECKS IF PASSED INTEGER ARRAY CONTAINS PASSED STRING, RETURNS TRUE IF YES
    private boolean checkIfInIntegerArray(int[] integers, int number)
    {
        for(int i = 0; i<integers.length; i++)
        {
            if(integers[i] == number)
                return true;
        }

        return false;
    }

    //CHECKS IF PASSED STRING ARRAY CONTAINS PASSED STRING, RETURNS TRUE IF YES
    private boolean checkIfInStringArray(String[] strings, String text)
    {
        for(int i = 0; i<strings.length; i++)
        {
            if(strings[i].equals(text))
                return true;
        }

        return false;
    }
}
