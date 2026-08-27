package com.cjc.payroll.service;

import com.cjc.payroll.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long empId);

    EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeeDTO);

    void deleteEmployee(Long empId);

    com.cjc.payroll.dto.PageResponseDTO<EmployeeDTO> searchEmployees(int pageNo, int pageSize, String sortBy, String sortDir, EmployeeDTO filterDTO);
}
