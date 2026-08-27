package com.cjc.payroll.controller;

import com.cjc.payroll.dto.DepartmentDTO;
import com.cjc.payroll.dto.ErrorResponse;
import com.cjc.payroll.dto.PageResponseDTO;
import com.cjc.payroll.service.DepartmentService;
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

@Tag(name = "Department Management", description = "APIs for managing departments, including CRUD operations, pagination, and multi-criteria search")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Operation(summary = "Create a new department", description = "Creates a department with name, code, and location.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Department created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request payload or validation failed",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO savedDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @Operation(summary = "Get all departments", description = "Retrieves an unpaginated list of all departments.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of departments retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDTO.class)))
    })
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @Operation(summary = "Search and paginate departments", description = "Search departments with optional filters (deptName, deptCode, location) and dynamic pagination/sorting.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Paginated list of departments retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = PageResponseDTO.class)))
    })
    @GetMapping("/search")
    public ResponseEntity<PageResponseDTO<DepartmentDTO>> searchDepartments(
            @Parameter(description = "Page number (0-indexed)", example = "0")
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @Parameter(description = "Page size limit", example = "10")
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @Parameter(description = "Field name to sort by", example = "deptId")
            @RequestParam(value = "sortBy", defaultValue = "deptId", required = false) String sortBy,
            @Parameter(description = "Sort direction (asc or desc)", example = "asc")
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
            @Parameter(description = "Filter by department name", example = "Information Technology")
            @RequestParam(value = "deptName", required = false) String deptName,
            @Parameter(description = "Filter by department code", example = "DEP-IT")
            @RequestParam(value = "deptCode", required = false) String deptCode,
            @Parameter(description = "Filter by office location", example = "Building A")
            @RequestParam(value = "location", required = false) String location
    ) {
        DepartmentDTO filterDTO = new DepartmentDTO();
        filterDTO.setDeptName(deptName);
        filterDTO.setDeptCode(deptCode);
        filterDTO.setLocation(location);

        PageResponseDTO<DepartmentDTO> response = departmentService.searchDepartments(pageNo, pageSize, sortBy, sortDir, filterDTO);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Get department by ID", description = "Fetches details of a specific department using its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department found and returned",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDTO.class))),
            @ApiResponse(responseCode = "404", description = "Department not found for given ID",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(
            @Parameter(description = "Department ID", example = "1")
            @PathVariable("id") Long id) {
        DepartmentDTO department = departmentService.getDepartmentById(id);
        return ResponseEntity.ok(department);
    }

    @Operation(summary = "Update an existing department", description = "Updates department details by department ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department updated successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = DepartmentDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid payload or validation failed",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Department not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(
            @Parameter(description = "Department ID to update", example = "1")
            @PathVariable("id") Long id,
            @Valid @RequestBody DepartmentDTO departmentDTO) {
        DepartmentDTO updatedDepartment = departmentService.updateDepartment(id, departmentDTO);
        return ResponseEntity.ok(updatedDepartment);
    }

    @Operation(summary = "Delete a department", description = "Deletes a department from the system by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Department deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Department not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(
            @Parameter(description = "Department ID to delete", example = "1")
            @PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Department deleted successfully with id: " + id);
    }
}
