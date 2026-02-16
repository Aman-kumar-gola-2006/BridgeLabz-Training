package com.employeeinformation;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagement {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1, "Abhay", 22, "Male", "IT", 2022, 30000));
		employees.add(new Employee(2, "Abha", 20, "Female", "IT", 2021, 30000));
		employees.add(new Employee(3, "Rohit", 25, "Male", "HR", 2020, 35000));
		employees.add(new Employee(4, "Sneha", 23, "Female", "Finance", 2022, 32000));
		employees.add(new Employee(5, "Amit", 28, "Male", "Sales", 2019, 45000));
		employees.add(new Employee(6, "Neha", 26, "Female", "Marketing", 2020, 40000));
		employees.add(new Employee(7, "Rahul", 30, "Male", "IT", 2018, 60000));
		employees.add(new Employee(8, "Pooja", 24, "Female", "HR", 2001, 34000));
		employees.add(new Employee(9, "Karan", 27, "Male", "Finance", 2019, 48000));
		employees.add(new Employee(10, "Anjali", 22, "Female", "IT", 2023, 28000));
		employees.add(new Employee(11, "Suresh", 35, "Male", "Admin", 2015, 55000));
		employees.add(new Employee(12, "Ritika", 29, "Female", "Marketing", 2018, 52000));
		employees.add(new Employee(13, "Vikas", 31, "Male", "Sales", 2017, 58000));
		employees.add(new Employee(14, "Meena", 33, "Female", "Finance", 2016, 60000));
		employees.add(new Employee(15, "Arjun", 26, "Male", "IT", 2020, 42000));
		employees.add(new Employee(16, "Kavita", 28, "Female", "HR", 2011, 46000));
		employees.add(new Employee(17, "Nitin", 34, "Male", "Admin", 2012, 65000));
		employees.add(new Employee(18, "Simran", 25, "Female", "Sales", 2001, 38000));
		employees.add(new Employee(19, "Deepak", 32, "Male", "Marketing", 2016, 57000));
		employees.add(new Employee(20, "Isha", 23, "Female", "IT", 2022, 31000));

		// 1. Count male and female employees
		Map<String, Long> genderCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("1. Gender count: " + genderCount);

		// 2. Print all departments
		System.out.println("2. Departments:");
		employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		// 3. Average age of male and female employees
		Map<String, Double> avgAgeByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("3. Average age by gender: " + avgAgeByGender);

		// 4. Highest paid employee
		Employee highestPaid = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println("4. Highest paid employee: " + highestPaid);

		// 5. Employees who joined after 2015
		System.out.println("5. Joined after 2015:");
		employees.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

		// 6. Number of employees in each department
		Map<String, Long> deptCount = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
		System.out.println("6. Employees per department: " + deptCount);

		// 7. Average salary of each department
		Map<String, Double> avgSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("7. Average salary by department: " + avgSalaryByDept);

		// 8. Youngest male employee in IT department
		Employee youngestMaleIT = employees.stream().filter(e -> e.getGender().equalsIgnoreCase("Male"))
				.filter(e -> e.getDepartment().equalsIgnoreCase("IT")).min(Comparator.comparingInt(Employee::getAge))
				.get();
		System.out.println("8. Youngest male in IT: " + youngestMaleIT);

		// 9. Most experienced employee
		Employee mostExperienced = employees.stream().min(Comparator.comparingInt(Employee::getYearOfJoining)).get();
		int experience = Year.now().getValue() - mostExperienced.getYearOfJoining();
		System.out.println("9. Most experienced: " + mostExperienced.getName() + " (" + experience + " years)");

		// 10. Male and female employees in Sales team
		Map<String, Long> salesGenderCount = employees.stream().filter(e -> e.getDepartment().equalsIgnoreCase("Sales"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("10. Sales gender count: " + salesGenderCount);

		// 11. Average salary of male and female employees
		Map<String, Double> avgSalaryByGender = employees.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("11. Avg salary by gender: " + avgSalaryByGender);

		// 12. Names of employees in each department
		Map<String, List<String>> namesByDept = employees.stream().collect(Collectors
				.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println("12. Names by department: " + namesByDept);

		// 13. Average and total salary of organization
		double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("13. Avg salary: " + avgSalary + ", Total salary: " + totalSalary);

		// 14. Employees with salary more than 25k
		System.out.println("14. Salary > 25k:");
		employees.stream().filter(e -> e.getSalary() > 25000).forEach(System.out::println);

		// 15. Highest paid employee
		System.out.println("15. Highest paid: " + highestPaid);

		// 16. Second highest paid employee
		Employee secondHighest = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(1).findFirst().get();
		System.out.println("16. Second highest paid: " + secondHighest);

		// 17. Third highest paid employee
		Employee thirdHighest = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				.skip(2).findFirst().get();
		System.out.println("17. Third highest paid: " + thirdHighest);

		// 18. Lowest paid employee
		Employee lowestPaid = employees.stream().min(Comparator.comparingDouble(Employee::getSalary)).get();
		System.out.println("18. Lowest paid: " + lowestPaid);

		// 19. Second lowest paid employee
		Employee secondLowest = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).skip(1)
				.findFirst().get();
		System.out.println("19. Second lowest paid: " + secondLowest);

		// 20. First five lowest paid employees
		System.out.println("20. First five lowest paid:");
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).limit(5)
				.forEach(System.out::println);

		// 21. First five highest paid employees
		System.out.println("21. First five highest paid:");
		employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5)
				.forEach(System.out::println);
	}
}