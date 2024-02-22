package crud.melashvili.onetoonemapping.dao;

import crud.melashvili.onetoonemapping.entity.Instructor;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
