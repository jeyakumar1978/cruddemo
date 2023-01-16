package com.multicloud.springboot.cruddemo.service;

import com.multicloud.springboot.cruddemo.dao.EmployeeDAO;
import com.multicloud.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeDAO employeeDAO;
    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> listAllEmployee() {
        return employeeDAO.listAllEmployee();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    public void createEmployee(Employee employee) {
        employeeDAO.createEmployee(employee);
    }


    @Override
    public void deleteEmployee(int theId) {
        employeeDAO.deleteEmployee(theId);
    }
}
