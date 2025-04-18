package com.example.mapstruct.Seeder;

import com.example.mapstruct.Entities.Department;
import com.example.mapstruct.Entities.Employee;
import com.example.mapstruct.Repositories.DepartmentsRepository;
import com.example.mapstruct.Repositories.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class SeederConfig {

    @Autowired
    private EmployeesRepository employeesRepository;
    @Autowired
    private DepartmentsRepository departmentsRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event){
        seedDepartments();
        seedEmployees();
    }

    private void seedDepartments() {
        if(departmentsRepository.findAll().iterator().hasNext() == false){
            Department office = new Department();
            office.setName("Office");
            Department factory = new Department();
            factory.setName("Factory");
            Department farm = new Department();
            farm.setName("Farm");
            departmentsRepository.save(office);
            departmentsRepository.save(factory);
            departmentsRepository.save(farm);
        }
    }

    private void seedEmployees() {
        if(employeesRepository.findAll().iterator().hasNext() == false){
            var office = departmentsRepository.findById(1L).get();
            var factory = departmentsRepository.findById(2L).get();
            var farm = departmentsRepository.findById(3L).get();
            Employee pesho = new Employee();
            pesho.setFirstName("Pesho");
            pesho.setLastName("Peshov");
            pesho.setSalary(2320L);
            pesho.setBirthDay(LocalDate.of(2003, 2, 1));
            pesho.setDepartments(List.of(farm));
            employeesRepository.save(pesho);
            Employee stamat = new Employee();
            stamat.setFirstName("Stamat");
            stamat.setLastName("Stamatov");
            stamat.setSalary(1520L);
            stamat.setBirthDay(LocalDate.of(1998, 5, 6));
            stamat.setDepartments(List.of(farm, factory));
            employeesRepository.save(stamat);
            Employee marincho = new Employee();
            marincho.setFirstName("Marincho");
            marincho.setLastName("Shefa");
            marincho.setSalary(6520L);
            marincho.setBirthDay(LocalDate.of(2001, 8, 4));
            marincho.setDepartments(List.of(office));
            employeesRepository.save(marincho);
            Employee maria = new Employee();
            maria.setFirstName("Maria");
            maria.setLastName("Kaceva");
            maria.setSalary(6520L);
            maria.setBirthDay(LocalDate.of(2001, 8, 4));
            maria.setDepartments(List.of(office, factory));
            employeesRepository.save(maria);
        }
    }
}
