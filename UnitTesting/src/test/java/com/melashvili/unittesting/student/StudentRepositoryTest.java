package com.melashvili.unittesting.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        // given
        String mail = "jamila@gmail.com";
        Student student = new Student("Jamila", mail, Gender.FEMALE);
        studentRepository.save(student);
        // when
        Boolean selectExistsEmail = studentRepository.selectExistsEmail(mail);
        // then
    }
}