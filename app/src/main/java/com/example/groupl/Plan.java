package com.example.groupl;

import java.util.ArrayList;

public class Plan {
    String planName;
    ArrayList<Recipe> recipeList = new ArrayList<>();
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