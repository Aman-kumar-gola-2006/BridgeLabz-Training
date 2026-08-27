package com.cjc.payroll.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Schema(description = "Data Transfer Object for Employee details")
public class EmployeeDTO {

    @Schema(description = "Unique Identifier of the Employee", example = "101", accessMode = Schema.AccessMode.READ_ONLY)
    private Long empId;

    @Schema(description = "Full Name of the Employee", example = "John Doe", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Employee name is required")
    private String name;

    @Schema(description = "Company Email Address of the Employee (Personal emails like @gmail.com are not permitted)", example = "john.doe@company.com", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(?!gmail\\.com$)[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Company email is required. @gmail.com is not allowed")
    private String email;

    @Schema(description = "Department Name", example = "Information Technology", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Department is required")
    private String dept;

    @Schema(description = "Monthly Salary of the Employee in USD/INR", example = "75000.00", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be greater than 0")
    private Double salary;

    @Schema(description = "Date of Joining (YYYY-MM-DD)", example = "2023-01-15", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "Date of joining is required")
    @PastOrPresent(message = "Date of joining cannot be in the future")
    private LocalDate doj;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long empId, String name, String email, String dept, Double salary, LocalDate doj) {
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
