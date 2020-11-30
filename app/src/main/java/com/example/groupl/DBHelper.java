package com.example.groupl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static String TableName="RacpiTable";
    public static String TableName2="IngriendensTable";
    public static String TableName3="PlansTable";
    public static String TableName4="RecipeAndPlanRelation";
    public static String C1="id";   //Primary key
    public static String C2="name"; //Recipe and ingredient name
    public static String C3="r_id"; //foreign key for recipe
    public static String C4="date"; //Date
    public static String C5="Plan_id"; //Date
    public static String C6="plan_name"; //Date

    public DBHelper(Context context){
        super(context, TableName,null,4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String Sql = "CREATE TABLE IF NOT EXISTS " //recipes table
                + TableName + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+C4+" INTEGER)";

        String Sql2 = "CREATE TABLE IF NOT EXISTS " //ingredients table
                + TableName2 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+ C3 +" INTEGER )";

        String Sql3 = "CREATE TABLE IF NOT EXISTS " //ingredients table
                + TableName3 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C6 + " text)";

        String Sql4 = "CREATE TABLE IF NOT EXISTS " //ingredients table
                + TableName4 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C5 + " INTEGER ,"+C3+" INTEGER )";

        db.execSQL(Sql2);
        db.execSQL(Sql);
        db.execSQL(Sql3);
        db.execSQL(Sql4);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String Sql="ALTER TABLE "+ TableName+"  ADD "+C4+" INTEGER";
        String Sql3 = "CREATE TABLE IF NOT EXISTS " //ingredients table
                + TableName3 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C6 + " text)";

        String Sql4 = "CREATE TABLE IF NOT EXISTS " //ingredients table
                + TableName4 + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C5 + " INTEGER ,"+C3+" INTEGER )";
        db.execSQL(Sql);
        db.execSQL(Sql3);
        db.execSQL(Sql4);

    }
}
