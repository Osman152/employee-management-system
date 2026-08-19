package com.employee.ems.services;

import com.employee.ems.dto.EmployeeRequestDTO;
import com.employee.ems.dto.EmployeeResponseDTO;
import com.employee.ems.model.Employee;
import com.employee.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    
    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO) {

        Employee employee = Employee.builder()
                .employeeCode(employeeRequestDTO.getEmployeeCode())
                .firstName(employeeRequestDTO.getFirstName())
                .lastName(employeeRequestDTO.getLastName())
                .email(employeeRequestDTO.getEmail())
                .phone(employeeRequestDTO.getPhone())
                .salary(employeeRequestDTO.getSalary())
                .designation(employeeRequestDTO.getDesignation())
                .joiningDate(employeeRequestDTO.getJoiningDate())
                .status(employeeRequestDTO.getStatus())
                .build();

        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeResponseDTO.builder()
                .id(savedEmployee.getId())
                .employeeCode(savedEmployee.getEmployeeCode())
                .firstName(savedEmployee.getFirstName())
                .lastName(savedEmployee.getLastName())
                .email(savedEmployee.getEmail())
                .phone(savedEmployee.getPhone())
                .salary(savedEmployee.getSalary())
                .designation(savedEmployee.getDesignation())
                .joiningDate(savedEmployee.getJoiningDate())
                .status(savedEmployee.getStatus())
                .build();

    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployeeById(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }
}
