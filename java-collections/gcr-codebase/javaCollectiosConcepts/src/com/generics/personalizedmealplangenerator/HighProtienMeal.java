package com.generics.personalizedmealplangenerator;

/*
 * High-Protein Meal implementation
 */
class HighProteinMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "High-Protein";
    }

    @Override
    public void showMeal() {
        System.out.println("High-Protein Meal: Eggs, Paneer, Protein Shake");
    }
}