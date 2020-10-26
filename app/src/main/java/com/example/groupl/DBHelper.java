package com.example.groupl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// TODO: Review this with Karim --> Confused on C1 -> C4 what is it?
public class DBHelper extends SQLiteOpenHelper {
    public static String RecipeTable ="RacpiTable";
    public static String ingredieantsTable ="IngriendensTable";
    public static String PlanTable="PlanTable";
    public static String C1="id"; // id for Recipe Table
    public static String C2="name"; // recipe name
    public static String C3="r_id"; // ingredieant id (foreign key)??????
    public static String C4="date"; // date recipe added
    public static String C5= "recipeID"; // recipe tables primary key


    public DBHelper(Context context){
        super(context, RecipeTable,null,4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String Sql = "CREATE TABLE IF NOT EXISTS "
                // (PrimaryKey, recipeName, date)
                + RecipeTable + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+C4+" INTEGER)";

        String Sql2 = "CREATE TABLE IF NOT EXISTS "
                // recipePrimaryKey (foreign Key), recipeName,
                + ingredieantsTable + "(" + C1+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ,"+ C3 +" INTEGER )";

        // create the plan table (plan primary key, name of plan, Recipe_ID (Foreign key))
        String Sql3 = "CREATE TABLE IF NOT EXISTS "
                + PlanTable + "(" +  C1  +  " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + C2 + " text ," + C5+ " INTEGER )";

        db.execSQL(Sql3);
        db.execSQL(Sql2);
        db.execSQL(Sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String Sql="ALTER TABLE "+ RecipeTable +"  ADD "+C4+" INTEGER"; // add ingrediants to recipe table
        String SQL_AddRecipeToPlan="ALTER TABLE "+ PlanTable +"  ADD "+C5+" INTEGER"; // add recipes to plan table

        db.execSQL(Sql);
        db.execSQL(SQL_AddRecipeToPlan);
    }
}
