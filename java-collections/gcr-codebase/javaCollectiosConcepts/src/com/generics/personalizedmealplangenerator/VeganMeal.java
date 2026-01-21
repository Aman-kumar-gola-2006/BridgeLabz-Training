package com.generics.personalizedmealplangenerator;

/*
 * Vegan Meal implementation
 */
class VeganMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Vegan";
    }

    @Override
    public void showMeal() {
        System.out.println("Vegan Meal: Quinoa, Chickpeas, Salad");
    }
}