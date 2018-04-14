package com.romain.mathieu.spreadscience.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static com.romain.mathieu.spreadscience.Controller.Activity.MainActivity.list;

/**
 * Created by Romain on 06/02/2018.
 */

public class SharedPreferencesUtils {

    private static final String MY_FILE_LIST = "ListSaved.xml";

    private static final String KEY_LIST = "KEY_LIST";


    public static void saveArrayList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_FILE_LIST, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        editor.putString(KEY_LIST, json);
        editor.apply();
    }

    public static void getArrayList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_FILE_LIST, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_LIST, null);
        Type type = new TypeToken<ArrayList<CardData>>() {
        }.getType();
        list = gson.fromJson(json, type);
    }

    public static boolean containsArrayList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(MY_FILE_LIST, Context.MODE_PRIVATE);
        return sharedPreferences.contains(KEY_LIST);
    }


}