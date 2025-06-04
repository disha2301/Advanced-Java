package com.gevernova.employee.service;

import com.gevernova.employee.dto.EmployeeRequestDTO;
import com.gevernova.employee.dto.EmployeeResponseDTO;
import com.gevernova.employee.entity.Employee;
import com.gevernova.employee.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    // Convert DTO to Entity
    private Employee mapToEntity(EmployeeRequestDTO dto){
        return Employee.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .build();
    }

    // Convert Entity to DTO
    private EmployeeResponseDTO mapToDTO(Employee employee){
        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }

    // Create and save new employee
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto){
        Employee employee = mapToEntity(dto);
        Employee saved = repo.save(employee);
        log.debug("Saved employee entity: {}", saved);
        return mapToDTO(saved);
    }

    // Get all employees
    public List<EmployeeResponseDTO> getAllEmployees(){
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get employee by ID
    public EmployeeResponseDTO getEmployeeId(Long id){
        Employee employee = repo.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee not found with ID: {}", id);
                    return new RuntimeException("Employee not found with id: " + id);
                });
        return mapToDTO(employee);
    }

    // Update existing employee
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto){
        Employee existing = repo.findById(id)
                .orElseThrow(() -> {
                    log.error("Cannot update. Employee not found with ID: {}", id);
                    return new RuntimeException("Employee not found with id: " + id);
                });

        existing.setName(dto.getName());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());
        Employee saved = repo.save(existing);
        log.debug("Updated employee entity: {}", saved);
        return mapToDTO(saved);
    }

    // Delete employee by ID
    public void deleteEmployee(Long id){
        log.warn("Deleting employee with ID: {}", id);
        repo.deleteById(id);
    }
}
