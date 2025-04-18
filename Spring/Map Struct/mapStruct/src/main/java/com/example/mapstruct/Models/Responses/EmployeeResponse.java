package com.example.mapstruct.Models.Responses;

import com.example.mapstruct.Entities.Department;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class EmployeeResponse {
    public String fullName;
    public int age;
    public Long salary;
    public List<Department> departments;
}
