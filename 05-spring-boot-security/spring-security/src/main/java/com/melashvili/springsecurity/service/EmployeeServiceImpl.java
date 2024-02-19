package com.melashvili.springsecurity.service;

import com.melashvili.springsecurity.dao.EmployeeRepository;
import com.melashvili.springsecurity.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return newEmployee;
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;

        if(result.isPresent()){
            return employee = result.get();
        } else{
            throw new RuntimeException("Employee by ID " + id + " was not present");
        }
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
