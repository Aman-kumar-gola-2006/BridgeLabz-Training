package com.inheritance.assistedproblems.animalhierarchy;

public class Cat extends Animal {
	public Cat(String name, int age) {
		super(name, age);
	}
	@Override
	public void makeSound(){
		System.out.println("Cat Meow.... Meow.....");
	}
}