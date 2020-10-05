package com.example.groupl;

import java.util.ArrayList;
public class Recipe {
    // class variables
    String recipeName;
    ArrayList<String> ingredients = new ArrayList();
    // default constructor
    public Recipe() {
        this.recipeName = "Untitled Recipe";
        this.ingredients = ingredients;
    }
    // parameterized constructor
    public Recipe(String recipeName, ArrayList<String> ingredientList) {
        this.recipeName = recipeName;
        this.ingredients = ingredientList;
    }
    // getters and setters
    public void setRecipeName (String recipeNameRecieved){
        recipeName = recipeNameRecieved;
    }
    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }
    public void removeIngredientName(String ingredient){
        ingredients.remove(ingredient);
    }
    public void removeIngredientIndex(int index){
        ingredients.remove(index);
    }
    public void clearIngredients (){
        ingredients.clear();
    }

    public ArrayList getIngredients () {
        return ingredients;
    }

}