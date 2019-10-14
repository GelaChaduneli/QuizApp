package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private Button submit;
    public static Integer counter=0;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submit=findViewById(R.id.submit_button);
        checkBox1=findViewById(R.id.cb1);
        checkBox2=findViewById(R.id.cb2);
        checkBox3=findViewById(R.id.cb3);
        checkBox4=findViewById(R.id.cb4);
        checkBox5=findViewById(R.id.cb5);




        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCount();
                Intent intent=new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(intent);
            }

        });

    }

    public void myCount(){
        if(checkBox1.isChecked()){
            counter++;
        }
        if(checkBox2.isChecked()){
            counter++;
        }
        if(checkBox3.isChecked()){
            counter++;
        }
        if(checkBox4.isChecked()){
            counter++;
        }
        if(checkBox5.isChecked()){
            counter++;
        }

    }
}