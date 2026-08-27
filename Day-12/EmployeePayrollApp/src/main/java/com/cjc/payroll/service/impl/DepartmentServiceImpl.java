package com.cjc.payroll.service.impl;

import com.cjc.payroll.dto.DepartmentDTO;
import com.cjc.payroll.entity.Department;
import com.cjc.payroll.exception.ResourceNotFoundException;
import com.cjc.payroll.repository.DepartmentRepository;
import com.cjc.payroll.service.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        if (departmentRepository.existsByDeptCode(departmentDTO.getDeptCode())) {
            throw new IllegalArgumentException("Department code already exists: " + departmentDTO.getDeptCode());
        }

        Department department = convertToEntity(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return convertToDTO(savedDepartment);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO getDepartmentById(Long deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + deptId));
        return convertToDTO(department);
    }

    @Override
    public DepartmentDTO updateDepartment(Long deptId, DepartmentDTO departmentDTO) {
        Department existingDepartment = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + deptId));

        if (!existingDepartment.getDeptCode().equalsIgnoreCase(departmentDTO.getDeptCode()) &&
                departmentRepository.existsByDeptCode(departmentDTO.getDeptCode())) {
            throw new IllegalArgumentException("Department code already exists: " + departmentDTO.getDeptCode());
        }

        existingDepartment.setDeptName(departmentDTO.getDeptName());
        existingDepartment.setDeptCode(departmentDTO.getDeptCode());
        existingDepartment.setLocation(departmentDTO.getLocation());

        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return convertToDTO(updatedDepartment);
    }

    @Override
    public void deleteDepartment(Long deptId) {
        Department department = departmentRepository.findById(deptId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + deptId));
        departmentRepository.delete(department);
    }

    @Override
    public PageResponseDTO<DepartmentDTO> searchDepartments(int pageNo, int pageSize, String sortBy, String sortDir, DepartmentDTO filterDTO) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Department probe = new Department();
        if (filterDTO != null) {
            probe.setDeptName(filterDTO.getDeptName());
            probe.setDeptCode(filterDTO.getDeptCode());
            probe.setLocation(filterDTO.getLocation());
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Department> example = Example.of(probe, matcher);
        Page<Department> page = departmentRepository.findAll(example, pageable);

        List<DepartmentDTO> content = page.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return new PageResponseDTO<>(content, page.getNumber(), page.getSize(), page.getTotalElements(), page.getTotalPages(), page.isLast());
    }

    private DepartmentDTO convertToDTO(Department department) {
        return new DepartmentDTO(
                department.getDeptId(),
                department.getDeptName(),
                department.getDeptCode(),
                department.getLocation()
        );
    }

    private Department convertToEntity(DepartmentDTO dto) {
        Department department = new Department();
        department.setDeptId(dto.getDeptId());
        department.setDeptName(dto.getDeptName());
        department.setDeptCode(dto.getDeptCode());
        department.setLocation(dto.getLocation());
        return department;
    }
}
