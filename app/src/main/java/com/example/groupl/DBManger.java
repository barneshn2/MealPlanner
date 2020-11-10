package com.example.groupl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// Is this updating objects based on what is in the database???????

public class DBManger {
    private SQLiteDatabase db;

    public DBManger(Context ctx) {
        DBHelper helper = new DBHelper(ctx);
        db = helper.getReadableDatabase();
    }
    // insert into recipe table
    public void insertRecpiToDataBase(Recipe r) { //this function will automatically insert Recipes to database
        ContentValues values = new ContentValues();
        values.put(DBHelper.C2, r.getName());
        values.put(DBHelper.C4, r.getLastUpdate());
        boolean b=db.insert(DBHelper.TableName, null,values) > -1;
        if (r.getIngredientsList().size()>0){
            for(Ingredients i:r.getIngredientsList()){
                i.setrID(getLastId());
                insertIngToDataBase(i);
            }
        }
    }
    public int getLastId(){ //this function will organize the order of the recipes in the database. forexample, the last entered recipe will be all the way the bottom of the table
        String SQl = "Select * From " + DBHelper.TableName +" ORDER BY "+ DBHelper.C1 +" DESC LIMIT 1";
        Cursor cursor = db.rawQuery(SQl, null);
        int id=0;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            id=cursor.getInt(cursor.getColumnIndex(DBHelper.C1));
            cursor.moveToNext();
        }
        cursor.close();
        return id;
        }

// insert into ingrediants table
    public boolean insertIngToDataBase(Ingredients r) { //checks the validity of the database

        ContentValues values = new ContentValues();
        values.put(DBHelper.C2, r.getContent());
        values.put(DBHelper.C3, r.getrID());
        return db.insert(DBHelper.TableName2, null, values) > -1;
    }


    public List<Recipe> getAllRecipe() { //this function will send all the recipes in the database to an arraylist to be printed in the recipe layout
        List<Recipe> ret = new ArrayList<>();
        String SQl = "Select * From " + DBHelper.TableName;
        Cursor cursor = db.rawQuery(SQl, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Recipe r = new Recipe();
            r.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.C1)));
            r.setName(cursor.getString(cursor.getColumnIndex(DBHelper.C2)));
            r.setLastUpdate(cursor.getLong(cursor.getColumnIndex(DBHelper.C4)));
            r.setIngredientsList(getAllIngredients(r.getId()));
            ret.add(r);
            cursor.moveToNext();
            Log.e("Test Data ",r.getName()+ r.getId());
        }

        cursor.close();
        return ret;
    }
    public Recipe getOneRecipeByID(int id ) {//allows you to view each recipe by using the ID
        Recipe r=new Recipe();
        String SQl = "Select * From " + DBHelper.TableName +" where "+ DBHelper.C1+"="+id;
        Cursor cursor = db.rawQuery(SQl, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            r.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.C1)));
            r.setName(cursor.getString(cursor.getColumnIndex(DBHelper.C2)));
            r.setIngredientsList(getAllIngredients(r.getId()));
            r.setLastUpdate(cursor.getLong(cursor.getColumnIndex(DBHelper.C4)));

            cursor.moveToNext();
            Log.e("Test Data ",r.getName()+ r.getId());
        }
        cursor.close();
        return r;
    }


    public List<Ingredients> getAllIngredients(int id) { //this function will send all the ingredients for each recipe to an arrayslist, so it shows all the ingreidents for each recipe
        List<Ingredients> ret = new ArrayList<>();
        String SQl = "Select * From " + DBHelper.TableName2 + " Where " + DBHelper.C3 + "=" + id;
        Cursor cursor = db.rawQuery(SQl, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Ingredients i = new Ingredients();
            i.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.C1)));
            i.setContent(cursor.getString(cursor.getColumnIndex(DBHelper.C2)));
            i.setrID(cursor.getInt(cursor.getColumnIndex(DBHelper.C3)));
            ret.add(i);
            cursor.moveToNext();
            Log.e("Test Ingreidents ",i.getContent()+ i.getId());
        }

        cursor.close();
        return ret;
    }


    public void updateRecpiToDataBase(Recipe r) {//this functions will replace ingredients in databse for new chosen ingreidents by the user
        ContentValues values = new ContentValues();
        values.put(DBHelper.C2, r.getName());
        values.put(DBHelper.C4, r.getLastUpdate());
        boolean b=db.update(DBHelper.TableName, values, DBHelper.C1+"="+r.getId(),null) > -1;
        deleteIngrad(r.getId());
        if (r.getIngredientsList().size()>0){
            for(Ingredients i:r.getIngredientsList()){
                insertIngToDataBase(i);
            }
        }
    }

    private void deleteIngrad(int id ){ //this function deletes ingredients from databse
          boolean b=db.delete(DBHelper.TableName2, DBHelper.C3 + "=" + id, null) > 0;
    }

    public void deleteRecipe(int id){
        db.delete(DBHelper.TableName,DBHelper.C1+"="+id,null);
        db.delete(DBHelper.TableName2,DBHelper.C3+"="+id,null);
    }


}
