package com.melashvili.springsecurity.rest;

import com.melashvili.springsecurity.entity.Employee;
import com.melashvili.springsecurity.service.EmployeeService;
import com.melashvili.springsecurity.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id){
        Employee tempEmp = employeeService.getById(id);
        if(tempEmp == null){
            throw new RuntimeException("Employee not found. ID - " + id);
        }
        return tempEmp;
    }

    @DeleteMapping("/employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.deleteById(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        if (id != employee.getId()) {
            throw new IllegalArgumentException("ID in the URL path does not match ID in the request body");
        }
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }
}
