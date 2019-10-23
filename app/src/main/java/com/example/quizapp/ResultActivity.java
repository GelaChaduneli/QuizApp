package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    public static TextView result;
    private Button doneButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.result);
        doneButton = findViewById(R.id.done_btn);


        result.setText(QuizActivity.counter.toString());

    }

    public void add(View view) {
        Results result = new Results();
        ResultManager resultManager = new ResultManager(this);
        resultManager.addResult(result);
        finish();

    }


}