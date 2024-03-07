package com.example.madassignment.models;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String dishesname, ingredients, instructions;

    public Recipe(String dishesname, String ingredients, String instructions) {
        this.dishesname = dishesname;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getDishesname() {
        return dishesname;
    }

    public void setDishesname(String d) {
        dishesname = d;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ing) {
        ingredients = ing;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String ins) {
        instructions = ins;
    }

    public String toString() {
        return dishesname;
    }
}
