package com.example.groupl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class SaveRetrieveFromPrefs {

    public static String LIST_KEY = "list_key";

    public static void saveToRecipeBook(Context context, ArrayList<Recipe> recipeBook) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(recipeBook);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY, jsonString);
        editor.apply();
    }

    public static ArrayList<Recipe> readRecipeBookFromPrefs(Context context){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY,"");
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Recipe>>() {}.getType();
        ArrayList<Recipe> recipeBook = gson.fromJson(jsonString,type);
        return recipeBook;
    }
}
