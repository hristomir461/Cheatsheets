package com.example.mapstruct.Repositories;

import com.example.mapstruct.Entities.Department;
import com.example.mapstruct.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends CrudRepository<Employee, Long> {
    List<Employee> findAll();
}
