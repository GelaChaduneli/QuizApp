package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends Activity {

    public static String LAST_RES="result";
    public TextView result;
    private SharePreferenceManager mSharePreferenceManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result=findViewById(R.id.result);
        mSharePreferenceManager=new SharePreferenceManager(this);
        saveLastResult(result);

        result.setText(QuizActivity.counter.toString());

    }


    public void saveLastResult(View view){
        if(view != null){
        mSharePreferenceManager.write(LAST_RES,result.getText().toString());}
        finish();
    }


}