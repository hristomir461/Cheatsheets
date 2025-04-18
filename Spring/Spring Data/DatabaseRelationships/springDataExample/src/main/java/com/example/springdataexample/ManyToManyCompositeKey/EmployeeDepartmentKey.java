package com.example.springdataexample.ManyToManyCompositeKey;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EmployeeDepartmentKey implements Serializable {
    @Column(name = "employee_id")
    Long employeeId;
    @Column(name = "department_id")
    Long departmentId;
}
