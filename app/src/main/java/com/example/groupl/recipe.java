package com.example.groupl;

import java.util.ArrayList;
import java.util.List;

public class recipe {
    // class variables
    String recipeName;
    ArrayList<String> ingredientsList = new ArrayList<>();

    // recipe constructor
    public recipe() {
    }

    // Set recipe name
    public void setRecipeName(String recipeNameGiven){
        recipeName = recipeNameGiven;
    }

    // Add ingredient to list
    public void addIngredient (String ingredient){
        ingredientsList.add(ingredient);
    }

    // remove ingredient with name as parameter
    public void removeingredientNamed (String ingredient){
        ingredientsList.remove(ingredient);
    }

    // remove ingredient at index as parameter
    public void removeingredientAt (String ingredient){
        ingredientsList.remove(ingredient);
    }

    // remove all ingredients
    public void clearIngredients (){
        ingredientsList.clear();
    }


}
