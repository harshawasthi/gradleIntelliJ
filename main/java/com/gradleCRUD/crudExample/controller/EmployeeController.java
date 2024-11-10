package com.gradleCRUD.crudExample.controller;

import com.gradleCRUD.crudExample.Entity.Employee;
import com.gradleCRUD.crudExample.service.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/code")
public class EmployeeController{

    //@Autowired
    private final EmployeeServiceInterface esi;
    @Autowired
    public EmployeeController(EmployeeServiceInterface esi) {
        this.esi = esi;
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee employeeSaved = esi.addEmployee(employee);
        return new ResponseEntity<> (employeeSaved, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> listOfAllEmp = esi.getAllEmployee();
        return new ResponseEntity<> (listOfAllEmp, HttpStatus.OK);
    }

    @GetMapping("/all/id/{id}")
    public Employee getEmployeeByID(@PathVariable int id){
        return esi.getEmployeeByID(id);
    }
    @GetMapping("/all/company/{company}")
    public List<Employee> getEmployeeByCompany(@PathVariable String company){
        return esi.getEmployeeByCompany(company);
    }

    @GetMapping("/all/city/{city}")
    public List<Employee> getEmployeeByCity(@PathVariable String city){
        return esi.getEmployeeByCity(city);
    }

    @PutMapping
    public Employee updateEmployee(@RequestBody Employee employee){
        return esi.updateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id){
       return esi.deleteEmployee(id);
    }

}
