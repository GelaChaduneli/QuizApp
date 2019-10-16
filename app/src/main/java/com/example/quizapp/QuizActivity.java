package com.example.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends Activity {

    private Button submit;
    public static Integer counter=0;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;
    private CheckBox checkBox5;
    private TextView mStatus;
    private TextView mLastResult;
    SharePreferenceManager manager;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        submit=findViewById(R.id.submit_button);
        mLastResult.findViewById(R.id.last_result);
        checkBox1=findViewById(R.id.cb1);
        checkBox2=findViewById(R.id.cb2);
        checkBox3=findViewById(R.id.cb3);
        checkBox4=findViewById(R.id.cb4);
        checkBox5=findViewById(R.id.cb5);
        mStatus=findViewById(R.id.status);
        manager=new SharePreferenceManager(this);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCount();
                Intent intent=new Intent(QuizActivity.this, ResultActivity.class);
                startActivity(intent);
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initView();
        counter=0;
    }

    private  void initView(){
        String lastResult=manager.read(ResultActivity.LAST_RES);
        if(lastResult!=null){
            mStatus.setText("Your last result: ");
            mLastResult.setText((lastResult));
        }else {
            mStatus.setText( "Never Played");
        }
        findViewById(R.id.changable_area).setVisibility(lastResult!=null ? View.VISIBLE : View.GONE);
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