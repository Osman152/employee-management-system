package com.employee.ems.services;

import com.employee.ems.model.Employee;

import java.util.*;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);
    
    void deleteEmployeeById(Long id);
}
