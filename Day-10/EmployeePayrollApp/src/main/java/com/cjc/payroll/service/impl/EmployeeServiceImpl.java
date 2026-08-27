package com.cjc.payroll.service.impl;

import com.cjc.payroll.dto.EmployeeDTO;
import com.cjc.payroll.entity.Employee;
import com.cjc.payroll.exception.ResourceNotFoundException;
import com.cjc.payroll.repository.EmployeeRepository;
import com.cjc.payroll.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import com.cjc.payroll.dto.PageResponseDTO;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        validateCompanyEmail(employeeDTO.getEmail());

        if (employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new IllegalArgumentException("Employee email already exists: " + employeeDTO.getEmail());
        }

        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO getEmployeeById(Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + empId));
        return convertToDTO(employee);
    }

    @Override
    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(empId)
        		
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + empId));

        validateCompanyEmail(employeeDTO.getEmail());

        if (!existingEmployee.getEmail().equalsIgnoreCase(employeeDTO.getEmail()) &&
                employeeRepository.existsByEmail(employeeDTO.getEmail())) {
            throw new IllegalArgumentException("Employee email already exists: " + employeeDTO.getEmail());
        }

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setEmail(employeeDTO.getEmail());
        existingEmployee.setDept(employeeDTO.getDept());
        existingEmployee.setSalary(employeeDTO.getSalary());
        existingEmployee.setDoj(employeeDTO.getDoj());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return convertToDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long empId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + empId));
        employeeRepository.delete(employee);
    }

    @Override
    public PageResponseDTO<EmployeeDTO> searchEmployees(int pageNo, int pageSize, String sortBy, String sortDir, EmployeeDTO filterDTO) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Employee probe = new Employee();
        if (filterDTO != null) {
            probe.setName(filterDTO.getName());
            probe.setDept(filterDTO.getDept());
            probe.setEmail(filterDTO.getEmail());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Employee> example = Example.of(probe, matcher);
        Page<Employee> page = employeeRepository.findAll(example, pageable);

        List<EmployeeDTO> content = page.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new PageResponseDTO<>(content, page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages(), page.isLast());
    }

    private void validateCompanyEmail(String email) {
        if (email != null && email.toLowerCase().endsWith("@gmail.com")) {
            throw new IllegalArgumentException("Company email is required. @gmail.com is not allowed");
        }
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getEmpId(),
                employee.getName(),
                employee.getEmail(),
                employee.getDept(),
                employee.getSalary(),
                employee.getDoj()
        );
    }

    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setEmpId(dto.getEmpId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDept(dto.getDept());
        employee.setSalary(dto.getSalary());
        employee.setDoj(dto.getDoj());
        return employee;
    }
}
