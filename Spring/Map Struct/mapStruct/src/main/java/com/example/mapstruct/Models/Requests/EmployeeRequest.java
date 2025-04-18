package com.example.mapstruct.Models.Requests;

import com.example.mapstruct.Entities.Department;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private Long salary;
    public List<Department> departments;
}
