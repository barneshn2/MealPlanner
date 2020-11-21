package com.example.groupl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DBManger {
    private SQLiteDatabase db;

    public DBManger(Context ctx) {
        DBHelper helper = new DBHelper(ctx);
        db = helper.getReadableDatabase();


    }
    public void inserNewPlan(Plan plan){

        ContentValues values = new ContentValues();
        values.put(DBHelper.C6, plan.getPlanName());
        values.put(DBHelper.C4, plan.getDate());
        boolean b=db.insert(DBHelper.TableName3, null,values) > -1;
        if (b) {
            int plainID=getLastPlanId();
            for(Recipe r:plan.getRecipeList()){
                ContentValues values2 = new ContentValues();
                values2.put(DBHelper.C5,plainID );
                values2.put(DBHelper.C3, r.getId());
                boolean b2=db.insert(DBHelper.TableName4, null,values2) > -1;

            }
        }
    }

    public int getLastPlanId(){ //this function will organize the order of the recipes in the database. forexample, the last entered recipe will be all the way the bottom of the table
        String SQl = "Select * From " + DBHelper.TableName3+" ORDER BY "+ DBHelper.C1 +" DESC LIMIT 1";
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
    public List<Plan>getAllPlanse(){
        List<Plan>retVaLList=new ArrayList<>();
        String SQl = "Select * From " + DBHelper.TableName3;
        Cursor cursor = db.rawQuery(SQl, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Plan r = new Plan();
            r.setId(cursor.getInt(cursor.getColumnIndex(DBHelper.C1)));
            r.setPlanName(cursor.getString(cursor.getColumnIndex(DBHelper.C6)));
            r.setRecipeList(getAllRecpByPlanId(r.getId()));
            r.setDate(cursor.getInt(cursor.getColumnIndex(DBHelper.C4)));
            retVaLList.add(r);
            cursor.moveToNext();

        }

        cursor.close();


        return  retVaLList;
    }
    private List<Recipe>getAllRecpByPlanId(int planid){
        List<Integer>recipIdList=new ArrayList<>();
        String SQl = "Select * From " + DBHelper.TableName4 +" where "+DBHelper.C5+"="+planid;
        Cursor cursor = db.rawQuery(SQl, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            recipIdList.add(cursor.getInt(cursor.getColumnIndex(DBHelper.C3)));

            cursor.moveToNext();

        }

        cursor.close();

        List<Recipe>retVaLList=new ArrayList<>();
        for (Integer i :recipIdList){
            Recipe r=getOneRecipeByID(i);
            Log.e("PlansRecId",r.getId()+"");
            retVaLList.add(r);

        }

        return  retVaLList;


    }

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
        String SQl = "Select * From " + DBHelper.TableName+" ORDER BY "+ DBHelper.C1 +" DESC LIMIT 1";
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
        String SQl = "Select * From " + DBHelper.TableName+" where "+ DBHelper.C1+"="+id;
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

    public void deleteRecipe(int id){//this function deletes recipes from database
        db.delete(DBHelper.TableName,DBHelper.C1+"="+id,null);
        db.delete(DBHelper.TableName2,DBHelper.C3+"="+id,null);

    }


//for every method above we need to have one for the plane side..

}
