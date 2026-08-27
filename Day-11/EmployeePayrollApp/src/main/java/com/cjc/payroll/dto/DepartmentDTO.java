package com.cjc.payroll.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Data Transfer Object for Department details")
public class DepartmentDTO {

    @Schema(description = "Unique Identifier of the Department", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long deptId;

    @Schema(description = "Department Name", example = "Information Technology", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Department name is required")
    private String deptName;

    @Schema(description = "Department Unique Code", example = "DEP-IT", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Department code is required")
    private String deptCode;

    @Schema(description = "Department Office Location", example = "Building A - Floor 4", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "Location is required")
    private String location;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Long deptId, String deptName, String deptCode, String location) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptCode = deptCode;
        this.location = location;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
