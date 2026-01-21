package com.generics.personalizedmealplangenerator;

/*
 * Keto Meal implementation
 */
class KetoMeal implements MealPlan {

    @Override
    public String getMealType() {
        return "Keto";
    }

    @Override
    public void showMeal() {
        System.out.println("Keto Meal: Grilled Chicken, Avocado, Olive Oil");
    }
}