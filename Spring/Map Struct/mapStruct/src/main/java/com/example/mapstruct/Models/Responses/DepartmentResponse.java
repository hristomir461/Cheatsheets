package com.example.mapstruct.Models.Responses;

import com.example.mapstruct.Entities.Employee;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DepartmentResponse {

    public String name;

    public List<Employee> topEmployees;

    public Double avgSalary;

    public List<EmployeeResponse> youngestEmployees;
}
