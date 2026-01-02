package com.inheritance.assistedproblems.animalhierarchy;

public class Bird extends Animal {

	public Bird(String name, int age) {
		super(name, age);
	}
	@Override
	public void makeSound(){
		System.out.println("Birds Chirp..... chirp...");
	}
}