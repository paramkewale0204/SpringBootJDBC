package com.practice.spring.api.dao;

import java.util.List;

import com.practice.spring.api.model.Employee;

public interface EmployeeDao {

    void save(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    void update(Employee employee);

    void delete(Long id);
}