package com.melashvili.springsecurity.service;

import com.melashvili.springsecurity.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee save(Employee employee);

    Employee getById(int id);

    void deleteById(int id);
}
