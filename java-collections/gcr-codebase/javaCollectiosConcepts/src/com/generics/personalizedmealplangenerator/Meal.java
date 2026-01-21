package com.generics.personalizedmealplangenerator;


import java.util.ArrayList;
import java.util.List;

/*
 * Generic Meal class
 * T is bounded to MealPlan to ensure only valid meals are handled
 */
class Meal<T extends MealPlan> {

    private List<T> mealPlans = new ArrayList<>();

    // Add meal plan to list
    public void addMealPlan(T mealPlan) {
        mealPlans.add(mealPlan);
    }

    // Get all meal plans
    public List<T> getMealPlans() {
        return mealPlans;
    }
}