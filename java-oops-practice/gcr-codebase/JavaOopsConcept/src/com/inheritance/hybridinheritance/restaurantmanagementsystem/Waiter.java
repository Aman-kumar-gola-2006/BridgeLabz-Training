package com.inheritance.hybridinheritance.restaurantmanagementsystem;

class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Waiter serves customers");
    }
}