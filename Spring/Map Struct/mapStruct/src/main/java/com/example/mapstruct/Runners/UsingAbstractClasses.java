package com.example.mapstruct.Runners;

import com.example.mapstruct.Mappers.AbstractClasses.DepartmentMapper;
import com.example.mapstruct.Mappers.AbstractClasses.EmployeeMapper;
import com.example.mapstruct.Mappers.Interfaces.IDepartmentMapper;
import com.example.mapstruct.Models.Requests.DepartmentRequest;
import com.example.mapstruct.Models.Requests.EmployeeRequest;
import com.example.mapstruct.Models.Responses.DepartmentResponse;
import com.example.mapstruct.Models.Responses.EmployeeResponse;
import com.example.mapstruct.Repositories.DepartmentsRepository;
import com.example.mapstruct.Repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class UsingAbstractClasses implements CommandLineRunner {
    @Autowired
    public EmployeesRepository employeesRepository;

    @Autowired
    public DepartmentsRepository departmentsRepository;

    @Autowired
    public EmployeeMapper employeeMapper;

    @Autowired
    public DepartmentMapper departmentMapper;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------UsingAbstractClasses-----------");
        var employees = employeesRepository.findAll();
        for (var employee:employees) {
            EmployeeRequest request = employeeMapper.toRequest(employee);
            EmployeeResponse response = employeeMapper.toResponse(request);
            System.out.println("Im " + response.getFullName() + " " + response.getAge() + " years old and I make " + response.getSalary());
            System.out.println("I work in these Departments: ");
            response.getDepartments().forEach(x -> System.out.println(x.getName()));
            System.out.println("----------------------------");
        }


        var departments = departmentsRepository.findAll();
        for (var department:departments) {
            DepartmentRequest request = departmentMapper.toRequest(department);
            DepartmentResponse response = departmentMapper.toResponse(request);
            System.out.println(response.getName() + " average salary is " + response.getAvgSalary());
            System.out.println("Employees sorted by high salaries");
            response.getTopEmployees().forEach(x -> System.out.println(x.getFirstName() + " " + x.getSalary()));
            System.out.println("Youngest employees");
            response.getYoungestEmployees().forEach(x -> System.out.println(x.getFullName() + " " + x.getAge()));
            System.out.println("--------------------------------");
        }
    }
}
