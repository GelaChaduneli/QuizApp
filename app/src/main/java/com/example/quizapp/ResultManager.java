package com.example.quizapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

public class ResultManager {
    private static final String RESULT_LIST_FILE = "result_list_file";
    private static final String RESULT_LIST_KEY = "result_list_key";

    private Context mContext;

    public ResultManager(Context mContext) {
        this.mContext = mContext;
    }

    public ResultStorage getResultStorage() {
        return read();
    }

    public void addResult(Results result){
        if(ResultActivity.result.toString()==null){
            throw new IllegalArgumentException("No Score Yet");
        }
        ResultStorage resultStorage=read();
        for(Results results : ResultStorage.getResults()){
            ResultStorage.getResults().add(result);
            write(resultStorage);
        }
    }



    private SharedPreferences getSharedReferences() {
        return mContext.getSharedPreferences(RESULT_LIST_FILE, Context.MODE_PRIVATE);
    }

    private void write(ResultStorage results){
        SharedPreferences.Editor editor=getSharedReferences().edit();
        editor.putString(RESULT_LIST_KEY,new Gson().toJson(results));
    }


    private ResultStorage read() {
        String jsonString = getSharedReferences().getString(RESULT_LIST_KEY, null);
        if (jsonString == null) {
            return new ResultStorage();
        }
        return new Gson().fromJson(jsonString,ResultStorage.class);
    }

}
