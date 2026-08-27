package com.cjc.payroll.controller;

import com.cjc.payroll.dto.EmployeeDTO;
import com.cjc.payroll.dto.ErrorResponse;
import com.cjc.payroll.dto.PageResponseDTO;
import com.cjc.payroll.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Employee Management", description = "APIs for managing employees, including CRUD operations, pagination, and multi-criteria search")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Create a new employee", description = "Saves a new employee entity with validated company email and salary constraints.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Employee created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request payload or validation failed",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all employees", description = "Retrieves a unpaginated list of all employees in the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list of employees",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class)))
    })
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @Operation(summary = "Search and paginate employees", description = "Search employees with optional filters (name, dept, email) and dynamic pagination/sorting.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paginated list of employees retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PageResponseDTO.class)))
    })
    @GetMapping("/search")
    public ResponseEntity<PageResponseDTO<EmployeeDTO>> searchEmployees(
            @Parameter(description = "Page number (0-indexed)", example = "0")
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "Page size limit", example = "10")
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @Parameter(description = "Field name to sort by", example = "empId")
            @RequestParam(value = "sortBy", defaultValue = "empId", required = false) String sortBy,
            @Parameter(description = "Sort direction (asc or desc)", example = "asc")
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
            @Parameter(description = "Filter by employee name (partial match)", example = "John")
            @RequestParam(value = "name", required = false) String name,
            @Parameter(description = "Filter by department name", example = "IT")
            @RequestParam(value = "dept", required = false) String dept,
            @Parameter(description = "Filter by email address", example = "john@company.com")
            @RequestParam(value = "email", required = false) String email
    ) {
        EmployeeDTO filterDTO = new EmployeeDTO();
        filterDTO.setName(name);
        filterDTO.setDept(dept);
        filterDTO.setEmail(email);

        PageResponseDTO<EmployeeDTO> response = employeeService.searchEmployees(pageNo, pageSize, sortBy, sortDir, filterDTO);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get employee by ID", description = "Fetches details of a specific employee using their unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee found and returned",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found for given ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(
            @Parameter(description = "Employee ID", example = "1")
            @PathVariable("id") Long id) {
        EmployeeDTO employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @Operation(summary = "Update an existing employee", description = "Updates employee details by employee ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EmployeeDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid payload or validation failed",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @Parameter(description = "Employee ID to update", example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody EmployeeDTO employeeDTO) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(updatedEmployee);
    }

    @Operation(summary = "Delete an employee", description = "Deletes an employee from the system by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(
            @Parameter(description = "Employee ID to delete", example = "1")
            @PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully with id: " + id);
    }
}
