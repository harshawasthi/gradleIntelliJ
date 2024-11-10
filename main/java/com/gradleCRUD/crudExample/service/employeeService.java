package com.gradleCRUD.crudExample.service;

import com.gradleCRUD.crudExample.Entity.Employee;
import com.gradleCRUD.crudExample.repo.EmployeeCrudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService implements EmployeeServiceInterface{
    @Autowired
    private EmployeeCrudRepo ecr;

    // CRUD
    // 1. CREATE
    public Employee addEmployee(Employee employee) {
        return ecr.save(employee);
    }

    // 2. READ all
    public List<Employee> getAllEmployee(){
        return ecr.findAll();
    }

    // 2. READ by ID
    public Employee getEmployeeByID(int id){
        return ecr.findById(id).get();
    }
    // 2. READ by different Field
    public List<Employee> getEmployeeByCompany(String company){
        return ecr.findByCompany(company);
    }

    // 2. READ by different Field using Mongo Query
    public List<Employee> getEmployeeByCity(String city){
        return ecr.findByCity(city);
    }

    // 3. UPDATE
    public Employee updateEmployee(Employee newEmployee){
        Employee empSave = ecr.findById(newEmployee.getId()).get();
        empSave.setCity(newEmployee.getCity());
        empSave.setAge(newEmployee.getAge());
        empSave.setCompany(newEmployee.getCompany());
        return ecr.save(empSave);
    }

    // 4. DELETE
    public String deleteEmployee(int id){
        ecr.deleteById(id);
        return id+" Employee deleted from DB since he left";
    }

}
