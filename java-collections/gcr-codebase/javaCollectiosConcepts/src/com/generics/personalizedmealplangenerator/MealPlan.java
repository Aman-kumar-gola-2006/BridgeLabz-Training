package com.generics.personalizedmealplangenerator;

/*
 * MealPlan interface
 * All meal categories will implement this interface
 */
interface MealPlan {

    // Method to return meal type name
    String getMealType();

    // Method to display meal details
    void showMeal();
}