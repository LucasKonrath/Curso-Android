package com.example.lucasdamaceno.troopersdex.utils;

import android.content.SharedPreferences;

/**
 * Created by lucas.damaceno on 18/11/2017.
 */

public class SharedPreferencesUtils {

    private SharedPreferences sharedPreferences;

    public SharedPreferencesUtils(SharedPreferences sharedPreferences){
        this.sharedPreferences = sharedPreferences;
    }

    public String get(String key){
       return sharedPreferences.getString(key, "");
    }

    public boolean hasValue(String key){
        return !sharedPreferences.getString(key, "").isEmpty();
    }

    public void save(String key, String value){
        sharedPreferences.edit().putString(key, value).apply();
    }

}
