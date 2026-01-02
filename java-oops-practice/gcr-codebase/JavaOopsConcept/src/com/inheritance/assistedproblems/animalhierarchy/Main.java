package com.inheritance.assistedproblems.animalhierarchy;

public class Main {

	public static void main(String[] args) {
		Bird bird = new Bird("KUKU" , 2);
		bird.makeSound();
		
		Cat cat = new Cat(null, 0);
		cat.makeSound();
		
		Dog dog = new Dog(null, 0);
		dog.makeSound();
	}

}