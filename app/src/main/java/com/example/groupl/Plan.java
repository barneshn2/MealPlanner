package com.example.groupl;

import java.util.ArrayList;
import java.util.List;

public class Plan {
    String planName;
    List<Recipe> recipeList = new ArrayList<>();
    long date;
    int id;

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // default constructor
    public Plan() {
        this.planName = "Untitled Plan";
        this.recipeList = recipeList;
    }
    // parameterized constructor
    public Plan(String planName, ArrayList<Recipe> recipeList) {
        this.planName = planName;
        this.recipeList = recipeList;
    }
    public void namePlan (String planName) {
        this.planName = planName;
    }
    public void addRecipe(Recipe myRecipe) {
        recipeList.add(myRecipe);
    }
    public void removeRecipeByName (Recipe myRecipe) {
        recipeList.remove(myRecipe);
    }
    public void removeRecipeByIndex (int index) {
        recipeList.remove(index);
    }
    public void clearRecipeList () {
        this.recipeList.clear();
    }

}