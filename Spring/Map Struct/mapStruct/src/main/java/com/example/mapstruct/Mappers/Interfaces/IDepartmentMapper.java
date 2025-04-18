package com.example.mapstruct.Mappers.Interfaces;

import com.example.mapstruct.Entities.Department;
import com.example.mapstruct.Entities.Employee;
import com.example.mapstruct.Models.Requests.DepartmentRequest;
import com.example.mapstruct.Models.Requests.EmployeeRequest;
import com.example.mapstruct.Models.Responses.DepartmentResponse;
import com.example.mapstruct.Models.Responses.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Comparator;
import java.util.stream.Collectors;

@Mapper
public interface IDepartmentMapper {
    IDepartmentMapper INSTANCE = Mappers.getMapper(IDepartmentMapper.class);
    @Mapping(target = "employees", source = "department.employees")
    DepartmentRequest toRequest(Department department);
    static DepartmentResponse toResponse(DepartmentRequest request){
        return DepartmentResponse.builder()
                .name(request.getName())
                .topEmployees(request.getEmployees().stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .collect(Collectors.toList()))
                .avgSalary(request.getEmployees().stream()
                        .mapToLong(x -> x.getSalary()).average().getAsDouble())
                .youngestEmployees(IEmployeeMapper.toResponses(request.getEmployees())
                        .stream().sorted(Comparator.comparing(EmployeeResponse::getAge))
                        .collect(Collectors.toList()))
                .build();
    }
}
