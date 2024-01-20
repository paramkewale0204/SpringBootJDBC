package com.practice.spring.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.practice.spring.api.model.Employee;
import com.practice.spring.api.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeService.findEmployeeById(id);
    }

    @GetMapping
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}

