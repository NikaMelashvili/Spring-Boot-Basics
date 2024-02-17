package com.melashvili.crud.app.dao;

import com.melashvili.crud.app.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee getEmployeeById(int id);

    Employee save(Employee employee);

    void deleteEmployeeById(int id);
}
