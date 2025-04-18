package com.example.mapstruct.Runners;

import com.example.mapstruct.Mappers.Interfaces.IDepartmentMapper;
import com.example.mapstruct.Mappers.Interfaces.IEmployeeMapper;
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
public class UsingInterfaces implements CommandLineRunner {
    @Autowired
    public EmployeesRepository employeesRepository;

    @Autowired
    public DepartmentsRepository departmentsRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------UsingInterfaces-----------");
        var employees = employeesRepository.findAll();
        for (var employee:employees) {
            EmployeeRequest request = IEmployeeMapper.INSTANCE.toRequest(employee);
            EmployeeResponse response = IEmployeeMapper.toResponse(request);
            System.out.println("Im " + response.getFullName() + " " + response.getAge() + " years old and I make " + response.getSalary());
            System.out.println("I work in these Departments: ");
            response.getDepartments().forEach(x -> System.out.println(x.getName()));
            System.out.println("----------------------------");
        }


        var departments = departmentsRepository.findAll();
        for (var department:departments) {
            DepartmentRequest request = IDepartmentMapper.INSTANCE.toRequest(department);
            DepartmentResponse response = IDepartmentMapper.toResponse(request);
            System.out.println(response.getName() + " average salary is " + response.getAvgSalary());
            System.out.println("Employees sorted by high salaries");
            response.getTopEmployees().forEach(x -> System.out.println(x.getFirstName() + " " + x.getSalary()));
            System.out.println("Youngest employees");
            response.getYoungestEmployees().forEach(x -> System.out.println(x.getFullName() + " " + x.getAge()));
            System.out.println("--------------------------------");
        }
    }
}
