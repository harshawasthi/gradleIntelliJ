package com.gradleCRUD.crudExample.repo;

import com.gradleCRUD.crudExample.Entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeCrudRepo extends MongoRepository<Employee, Integer> {

    List<Employee> findByCompany(String company);

    @Query("{city: ?0 }")
    List<Employee> findByCity(String city);
}
