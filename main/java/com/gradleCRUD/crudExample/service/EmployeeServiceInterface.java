package com.gradleCRUD.crudExample.service;

import com.gradleCRUD.crudExample.Entity.Employee;

import java.util.List;

public interface EmployeeServiceInterface {

    public Employee addEmployee(Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeByID(int id);
    public List<Employee> getEmployeeByCompany(String company);
    public List<Employee> getEmployeeByCity(String city);
    public Employee updateEmployee(Employee newEmployee);
    public String deleteEmployee(int id);
}
