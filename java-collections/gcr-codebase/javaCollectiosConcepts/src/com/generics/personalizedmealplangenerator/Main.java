package com.generics.personalizedmealplangenerator;

public class Main {

	 public static void main(String[] args) {

	        // Creating meal containers for different categories
	        Meal<VegetarianMeal> vegetarianMeals = new Meal<>();
	        Meal<VeganMeal> veganMeals = new Meal<>();
	        Meal<KetoMeal> ketoMeals = new Meal<>();
	        Meal<HighProteinMeal> highProteinMeals = new Meal<>();

	        // Adding meals
	        vegetarianMeals.addMealPlan(new VegetarianMeal());
	        veganMeals.addMealPlan(new VeganMeal());
	        ketoMeals.addMealPlan(new KetoMeal());
	        highProteinMeals.addMealPlan(new HighProteinMeal());

	        // Generating personalized meal plans dynamically
	        MealGenerator.generateMealPlan(vegetarianMeals.getMealPlans().get(0));
	        System.out.println();

	        MealGenerator.generateMealPlan(veganMeals.getMealPlans().get(0));
	        System.out.println();

	        MealGenerator.generateMealPlan(ketoMeals.getMealPlans().get(0));
	        System.out.println();

	        MealGenerator.generateMealPlan(highProteinMeals.getMealPlans().get(0));
	    }
	}