package com.example.haosiong.tester;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Questions extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private TextView numQuestion;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private static int mError = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Connect variable with XML
        mScoreView = findViewById(R.id.score);
        mQuestionView = findViewById(R.id.question);
        numQuestion = findViewById(R.id.numQuestion);
        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);

        updateQuestion();

        //Start of button listener for button 1
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logic for Button goes in here
                mQuestionLibrary.setmAnswer(mQuestionNumber-1, (String) mButtonChoice1.getText());
                if(mButtonChoice1.getText() == mAnswer){ //Correct
                    mScore++;
                    updateScore(mScore);
                }else{ //Wrong
                    mError++;
                }
                updateQuestion();
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logic for Button goes in here
                mQuestionLibrary.setmAnswer(mQuestionNumber-1, (String) mButtonChoice1.getText());
                if(mButtonChoice2.getText() == mAnswer){ //Correct
                    mScore++;
                    updateScore(mScore);
                }else{ //Wrong
                    mError++;
                }
                updateQuestion();
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Logic for Button goes in here
                mQuestionLibrary.setmAnswer(mQuestionNumber-1, (String) mButtonChoice1.getText());
                if(mButtonChoice3.getText() == mAnswer){ //Correct
                    mScore++;
                    updateScore(mScore);
                }else{ //Wrong
                    mError++;
                }
                updateQuestion();
            }
        });
        //End of button listener
    }

    private void updateQuestion(){
        if(mQuestionNumber < mQuestionLibrary.getLength()) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            numQuestion.setText(""+ mQuestionLibrary.getLength());
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mQuestionNumber++;
        }else{
            Toast.makeText(Questions.this,"Test is over", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Report.class);
            startActivity(intent);
        }
    }

    private void updateScore(int point){
        mScoreView.setText("" + mScore);
    }

    public int getErrors(){
        return mError;
    }
}
