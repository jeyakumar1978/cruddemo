package com.multicloud.springboot.cruddemo.service;

import com.multicloud.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> listAllEmployee();
    public Employee findById(int theId);
    public void createEmployee(Employee employee);
    public void deleteEmployee(int theId);
}
