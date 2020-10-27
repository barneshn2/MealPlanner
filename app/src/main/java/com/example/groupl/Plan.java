package com.example.groupl;

import java.util.ArrayList;

public class Plan {
    private int rID;
    private String content;
    private int id;
    private String name;
    String planName;
    ArrayList<Recipe> recipeList = new ArrayList<>();
    // default constructor
    public Plan() {
        this.planName = "Untitled Plan";
        this.recipeList = recipeList;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // recipe ID
    public int getrID() {
        return rID;
    }

    public void setrID(int rID) {
        this.rID = rID;
    }
    // recipe content
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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