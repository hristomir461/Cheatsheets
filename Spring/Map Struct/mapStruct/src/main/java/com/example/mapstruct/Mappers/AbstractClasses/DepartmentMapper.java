package com.example.mapstruct.Mappers.AbstractClasses;

import com.example.mapstruct.Entities.Department;
import com.example.mapstruct.Entities.Employee;
import com.example.mapstruct.Mappers.Interfaces.IEmployeeMapper;
import com.example.mapstruct.Models.Requests.DepartmentRequest;
import com.example.mapstruct.Models.Responses.DepartmentResponse;
import com.example.mapstruct.Models.Responses.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring")
@Component
public abstract class DepartmentMapper {

    @Autowired
    public EmployeeMapper employeeMapper;

    @Mapping(target = "employees", source = "department.employees")
    public abstract DepartmentRequest toRequest(Department department);

    public DepartmentResponse toResponse(DepartmentRequest request){
        return DepartmentResponse.builder()
                .name(request.getName())
                .topEmployees(request.getEmployees().stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .collect(Collectors.toList()))
                .avgSalary(request.getEmployees().stream()
                        .mapToLong(x -> x.getSalary()).average().getAsDouble())
                .youngestEmployees(employeeMapper.toResponses(request.getEmployees())
                        .stream().sorted(Comparator.comparing(EmployeeResponse::getAge))
                        .collect(Collectors.toList()))
                .build();
    }
}
