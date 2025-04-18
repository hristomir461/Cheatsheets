package com.example.springdataexample.ManyToManyCompositeKey;

import com.example.springdataexample.ManyToMany.Course;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    @OneToMany(mappedBy = "employee")
    private List<EmployeeDepartment> departments;
}