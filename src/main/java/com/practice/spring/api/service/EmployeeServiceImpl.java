package com.practice.spring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.spring.api.dao.EmployeeDao;
import com.practice.spring.api.model.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.update(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeDao.delete(id);
    }
}
