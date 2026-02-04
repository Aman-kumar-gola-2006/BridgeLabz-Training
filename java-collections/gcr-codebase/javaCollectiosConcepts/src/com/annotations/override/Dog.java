package com.annotations.override;

//Child class
class Dog extends Animal {

 // Overrides parent method
 @Override
 public void makeSound() {
     System.out.println("Dog barks");
 }
}