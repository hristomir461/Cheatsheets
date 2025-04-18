package com.example.mapstruct.Repositories;

import com.example.mapstruct.Entities.Department;
import com.example.mapstruct.Entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DepartmentsRepository extends CrudRepository<Department, Long> {
    List<Department> findAll();
}
