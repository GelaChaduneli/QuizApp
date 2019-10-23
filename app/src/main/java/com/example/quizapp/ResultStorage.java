package com.example.quizapp;

import java.util.ArrayList;
import java.util.List;

public class ResultStorage {
    private  static List<Results> results=new ArrayList<>();

    public  static List<Results> getResults(){
        return results;
    }

}
