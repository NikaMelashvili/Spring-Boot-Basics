package com.melashvili.cruddemo.dao;

import com.melashvili.cruddemo.entity.Student;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void updates(Student student);

    void delete(Integer id);

    int deleteAll();
}
