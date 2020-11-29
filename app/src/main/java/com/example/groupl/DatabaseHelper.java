package com.example.groupl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String p = "DatabaseHelper";
    public static final String TABLE_NAME = "recipe_table";
    public static final String first = "ID";
    public static final String Second = "name";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABLE_NAME, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table = "create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + Second + "TEXT)";
        sqLiteDatabase.execSQL(table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //  sqLiteDatabase("DROP IF TABLE EXISTS" + TABLE_NAME);
        //  sqLiteDatabase.execSQL();
    }
}
