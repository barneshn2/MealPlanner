package com.example.groupl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String TableName="RacpiTable";
    public static String TableName2="IngriendensTable";
    public static String C1="id";
    public static String C2="name";
    public static String C3="r_id";
    public static String C4="date";

    public DBHelper(Context context){
        super(context, TableName,null,3);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String Sql = "CREATE TABLE IF NOT EXISTS "
                + TableName + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+C4+" INTEGER)";

        String Sql2 = "CREATE TABLE IF NOT EXISTS "
                + TableName2 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+ C3 +" INTEGER )";


        db.execSQL(Sql2);
        db.execSQL(Sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String Sql="ALTER TABLE "+ TableName+"  ADD "+C4+" INTEGER";

        db.execSQL(Sql);

    }
}
