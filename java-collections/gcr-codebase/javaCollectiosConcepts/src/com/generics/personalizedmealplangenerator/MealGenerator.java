package com.generics.personalizedmealplangenerator;

/*
 * Utility class containing generic methods
 */
class MealGenerator {

    /*
     * Generic method to validate and generate meal plan
     * Accepts only MealPlan types using bounded type parameter
     */
    public static <T extends MealPlan> void generateMealPlan(T mealPlan) {
        System.out.println("Generating Personalized Meal Plan...");
        System.out.println("Meal Type: " + mealPlan.getMealType());
        mealPlan.showMeal();
    }
}