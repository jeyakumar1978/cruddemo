package com.multicloud.springboot.cruddemo.rest;

import com.multicloud.springboot.cruddemo.entity.Employee;
import com.multicloud.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/employees")
   public List<Employee> findAllEmployee(){
      return employeeService.listAllEmployee();
   }

    @RequestMapping("/employees/{employeeId}")
    public Employee getEmployeeDetails(@PathVariable int employeeId) throws Exception {
        Employee employee = employeeService.findById(employeeId);
        if(employee == null){
            throw new Exception("Employee Not Found"+employeeId);
        }
        return employee;
    }
    @PostMapping("/createEmp")
    public Employee CreateEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.createEmployee(employee);
        return employee;
    }
    @PutMapping("/updateEmp")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }
 @DeleteMapping("/deleteEmp/{employeeId}")
 public void deleteEmp(@PathVariable int employeeId){
     Employee employee = employeeService.findById(employeeId);
     employeeService.deleteEmployee(employeeId);
 }
}
