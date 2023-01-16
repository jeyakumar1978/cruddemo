package com.multicloud.springboot.cruddemo.dao;

import com.multicloud.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> listAllEmployee();
    public Employee findById(int theId);
    public void createEmployee(Employee employee);
    public void deleteEmployee(int theId);

}
