package com.example.quizapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePreferenceManager {
    private static final String FILE_NAME="My_File_For_Results";
    private Context mContext;

    public SharePreferenceManager(Context context){
        if(context==null){
            throw new IllegalArgumentException("Context should not be empty!");
        }
        this.mContext=context;
    }

    public void write(String key,String value){
        SharedPreferences.Editor editor=getSharedPreferences().edit();
        editor.putString(key,value);
        editor.commit();
    }

    public String read(String key){
        return getSharedPreferences().getString(key,null);
    }

    private SharedPreferences getSharedPreferences(){
        return mContext.getSharedPreferences(FILE_NAME,Context.MODE_PRIVATE);
    }
}
