package com.practice.spring.api.service;

import java.util.List;

import com.practice.spring.api.model.Employee;

public interface EmployeeService {

    void saveEmployee(Employee employee);

    Employee findEmployeeById(Long id);

    List<Employee> findAllEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployee(Long id);
}