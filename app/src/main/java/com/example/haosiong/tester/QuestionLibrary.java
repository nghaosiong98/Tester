package com.example.haosiong.tester;

import java.util.HashMap;

public class QuestionLibrary {

    private String mQuestions [] = {
            "Q1",
            "Q2",
            "Q3",
            "Q4",
            "Q5"
    };

    private String mChoices [][] = {
            {"O1","O2","O3"},
            {"O1","O2","O3"},
            {"O1","O2","O3"},
            {"O1","O2","O3"},
            {"O1","O2","O3"}
    };

//    private HashMap<String,String> mCorrectAnswer = new HashMap<>();


    private String mCorrectAnswer[] = {"O1","O2","O3","O1","O2"};

    private String mAnswer[] = new String[getLength()];

    public void setmAnswer(int a, String answer){
        mAnswer[a]=answer;;
    }

//    public void setWrongAnswer(int a, String answer){
//        wrongAnswer[a] = new String[]{answer, mCorrectAnswer[a]};
//    }

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a){
        return mChoices[a][0];
    }

    public String getChoice2(int a){
        return mChoices[a][1];
    }

    public String getChoice3(int a){
        return mChoices[a][2];
    }

    public String getCorrectAnswer(int a){
        return mCorrectAnswer[a];
    }

    public int getLength(){
        return mQuestions.length;
    }
}
