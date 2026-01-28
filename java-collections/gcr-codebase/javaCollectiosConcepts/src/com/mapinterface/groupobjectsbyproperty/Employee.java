package com.mapinterface.groupobjectsbyproperty;

class Employee {

    String name;
    String department;

    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}
