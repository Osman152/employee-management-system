package com.employee.ems.services;

import com.employee.ems.dto.EmployeeRequestDTO;
import com.employee.ems.dto.EmployeeResponseDTO;
import com.employee.ems.model.Employee;
import jakarta.validation.Valid;

import java.util.*;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
    
    void deleteEmployeeById(Long id);
}
