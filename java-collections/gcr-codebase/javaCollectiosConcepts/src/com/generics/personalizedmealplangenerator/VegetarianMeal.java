package com.generics.personalizedmealplangenerator;

/*
 * Vegetarian Meal implementation
 */
class VegetarianMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegetarian";
    }

    @Override
    public void showMeal() {
        System.out.println("Vegetarian Meal: Rice, Dal, Vegetable Curry");
    }
}