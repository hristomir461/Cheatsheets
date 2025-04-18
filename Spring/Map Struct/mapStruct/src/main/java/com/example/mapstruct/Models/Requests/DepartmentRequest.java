package com.example.mapstruct.Models.Requests;

import com.example.mapstruct.Entities.Employee;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class DepartmentRequest {
    private String name;
    private List<Employee> employees;
}
