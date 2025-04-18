package com.example.springdataexample.ManyToManyCompositeKey;

import jakarta.persistence.*;

@Entity
public class EmployeeDepartment {
    @EmbeddedId
    private EmployeeDepartmentKey id;
    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @ManyToOne
    @MapsId("departmentId")
    @JoinColumn(name = "department_id")
    private Department department;
}
