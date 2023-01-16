package com.multicloud.springboot.cruddemo.dao;

import com.multicloud.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;

import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> listAllEmployee() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query employee = currentSession.createQuery("from Employee", Employee.class);
        List<Employee> lstEmployee = employee.getResultList();
        return lstEmployee;
    }
    @Transactional
    public Employee findById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        Employee employee = currentSession.get(Employee.class, theId);
        return employee;
    }
    @Transactional
    @Override
    public void createEmployee(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(employee);
    }
    @Transactional
    public void deleteEmployee(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();

    }
}
