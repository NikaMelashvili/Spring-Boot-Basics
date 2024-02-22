package crud.melashvili.onetoonemapping.dao;

import crud.melashvili.onetoonemapping.entity.Course;
import crud.melashvili.onetoonemapping.entity.Instructor;
import crud.melashvili.onetoonemapping.entity.InstructorDetail;

import java.util.List;

public interface InstructorDAO {
    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorMethodById(int id);

    List<Course> findCoursesByInstructorId(int id);
}
