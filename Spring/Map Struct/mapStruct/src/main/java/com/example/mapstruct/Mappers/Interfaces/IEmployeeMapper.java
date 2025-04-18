package com.example.mapstruct.Mappers.Interfaces;

import com.example.mapstruct.Entities.Employee;
import com.example.mapstruct.Models.Requests.EmployeeRequest;
import com.example.mapstruct.Models.Responses.EmployeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface IEmployeeMapper {
    IEmployeeMapper INSTANCE = Mappers.getMapper(IEmployeeMapper.class);
    @Mapping(target = "departments", source = "employee.departments")
    EmployeeRequest toRequest(Employee employee);
    static EmployeeResponse toResponse(EmployeeRequest request){
        return EmployeeResponse
                .builder()
                .fullName(request.getFirstName() + " " + request.getLastName())
                .age(Period.between(request.getBirthDay(), LocalDate.now()).getYears())
                .salary(request.getSalary())
                .departments(request.getDepartments())
                .build();
    }
    static List<EmployeeResponse> toResponses(List<Employee> request){
        return request.stream().map(x -> EmployeeResponse
                .builder()
                .fullName(x.getFirstName() + " " + x.getLastName())
                .age(Period.between(x.getBirthDay(), LocalDate.now()).getYears())
                .salary(x.getSalary())
                .departments(x.getDepartments())
                .build()).collect(Collectors.toList());
    }
}
