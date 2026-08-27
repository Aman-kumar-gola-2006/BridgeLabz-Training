package com.cjc.payroll.service;

import com.cjc.payroll.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

    List<DepartmentDTO> getAllDepartments();

    DepartmentDTO getDepartmentById(Long deptId);

    DepartmentDTO updateDepartment(Long deptId, DepartmentDTO departmentDTO);

    void deleteDepartment(Long deptId);

    com.cjc.payroll.dto.PageResponseDTO<DepartmentDTO> searchDepartments(int pageNo, int pageSize, String sortBy, String sortDir, DepartmentDTO filterDTO);
}
