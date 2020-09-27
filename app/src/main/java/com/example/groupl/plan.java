package com.example.groupl;

import java.util.ArrayList;

public class plan {
    String planName;
    ArrayList<recipe> recipeList = new ArrayList<>();
    // default constructor
    public plan () {
        this.planName = "Untitled Plan";
        this.recipeList = recipeList;
    }
    // parameterized constructor
    public plan (String planName, ArrayList<recipe> recipeList) {
        this.planName = planName;
        this.recipeList = recipeList;
    }
    public void namePlan (String planName) {
        this.planName = planName;
    }
    public void addRecipe(recipe myRecipe) {
        recipeList.add(myRecipe);
    }
    public void removeRecipeByName (recipe myRecipe) {
        recipeList.remove(myRecipe);
    }
    public void removeRecipeByIndex (int index) {
        recipeList.remove(index);
    }
    public void clearRecipeList () {
        this.recipeList.clear();
    }

}