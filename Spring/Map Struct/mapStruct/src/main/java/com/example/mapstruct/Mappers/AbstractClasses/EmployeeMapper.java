package com.example.mapstruct.Mappers.AbstractClasses;

import com.example.mapstruct.Entities.Employee;
import com.example.mapstruct.Models.Requests.EmployeeRequest;
import com.example.mapstruct.Models.Responses.EmployeeResponse;
import com.example.mapstruct.Repositories.DepartmentsRepository;
import com.example.mapstruct.Repositories.EmployeesRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Component
public abstract class EmployeeMapper {

    @Autowired
    public DepartmentsRepository repo;

    @Mapping(target = "departments", source = "employee.departments")
    public abstract EmployeeRequest toRequest(Employee employee);

    public EmployeeResponse toResponse(EmployeeRequest request) {
        return EmployeeResponse
                .builder()
                .fullName(request.getFirstName() + " " + request.getLastName())
                .age(Period.between(request.getBirthDay(), LocalDate.now()).getYears())
                .salary(request.getSalary())
                .departments(request.getDepartments())
                .build();
    }
    public List<EmployeeResponse> toResponses(List<Employee> request){
        return request.stream().map(x -> EmployeeResponse
                .builder()
                .fullName(x.getFirstName() + " " + x.getLastName())
                .age(Period.between(x.getBirthDay(), LocalDate.now()).getYears())
                .salary(x.getSalary())
                .departments(x.getDepartments())
                .build()).collect(Collectors.toList());
    }
}
