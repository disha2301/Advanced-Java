package com.gevernova.employee.service;

import com.gevernova.employee.dto.EmployeeRequestDTO;
import com.gevernova.employee.dto.EmployeeResponseDTO;
import com.gevernova.employee.entity.Employee;
import com.gevernova.employee.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo){
        this.repo = repo;
    }

    private Employee mapToEntity(EmployeeRequestDTO dto){
        return Employee.builder()
                .name(dto.getName())
                .department(dto.getDepartment())
                .salary(dto.getSalary())
                .build();
    }
    private EmployeeResponseDTO mapToDTO(Employee employee){
        return EmployeeResponseDTO.builder()
                .id(employee.getId())
                .name(employee.getName())
                .department(employee.getDepartment())
                .salary(employee.getSalary())
                .build();
    }
    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO dto){
        Employee employee = mapToEntity(dto);
        Employee saved = repo.save(employee);
        return mapToDTO(saved);
    }
    public List<EmployeeResponseDTO> getAllEmployees(){
        return repo.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    public EmployeeResponseDTO getEmployeeId(Long id){
        Employee employee = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found with id: " + id));
        return mapToDTO(employee);
    }
    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto){
        Employee existing = repo.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee not found with id: " + id));
        existing.setName(dto.getName());
        existing.setDepartment(dto.getDepartment());
        existing.setSalary(dto.getSalary());
        Employee saved = repo.save(existing);
        return mapToDTO(saved);
    }
    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
}
