package com.melashvili.crud.app.rest;

import com.melashvili.crud.app.entity.Employee;
import com.melashvili.crud.app.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        if(employee == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee newEmployee = employeeService.save(employee);
        return newEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee deletedEmployee = employeeService.getEmployeeById(id);
        if(deletedEmployee == null){
            throw new RuntimeException("this employee id doesn't exist - " + id);
        }
        employeeService.deleteEmployeeById(id);
        return "Employee by id " + id + " was deleted.";
    }
}
