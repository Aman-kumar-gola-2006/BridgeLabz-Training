package com.cjc.payroll.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empId;

    private String name;

    private String email;

    private String dept;

    private Double salary;

    private LocalDate doj;

    
    
    public Employee() {
    }

    public Employee(Long empId, String name, String email, String dept, Double salary, LocalDate doj) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.salary = salary;
        this.doj = doj;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
    	
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }
}
