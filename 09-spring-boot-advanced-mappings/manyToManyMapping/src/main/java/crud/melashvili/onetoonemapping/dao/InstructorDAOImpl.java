package crud.melashvili.onetoonemapping.dao;

import crud.melashvili.onetoonemapping.entity.Course;
import crud.melashvili.onetoonemapping.entity.Instructor;
import crud.melashvili.onetoonemapping.entity.InstructorDetail;
import crud.melashvili.onetoonemapping.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDAOImpl implements InstructorDAO{

    private EntityManager manager;

    public InstructorDAOImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        manager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return manager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor tempInstructor = manager.find(Instructor.class, id);
        manager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return manager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorMethodById(int id) {
        Instructor temp = manager.find(Instructor.class, id);
        List<Course> courses = temp.getCourses();
        for(Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }
        manager.remove(temp);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = manager.createQuery(
                "from Course where instructor.id = :data", Course.class
        );
        query.setParameter("data", id);
        List<Course> temp = query.getResultList();
        return temp;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = manager.createQuery(
                "select i from Instructor i " +
                        "JOIN fetch i.courses " +
                        "where i.id = :data", Instructor.class);
        query.setParameter("data", id);
        System.out.println(query);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor temp) {
        manager.merge(temp);
    }

    @Override
    @Transactional
    public void update(Course course) {
        manager.merge(course);
    }

    @Override
    public Course findById(int id) {
        return manager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = manager.find(Course.class, id);
        manager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        manager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = manager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.reviews "
                + "WHERE c.id = :data", Course.class
        );
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query = manager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "WHERE c.id = :data", Course.class
        );
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findCourseAndStudentByStudentId(int id) {
        TypedQuery<Student> query = manager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "WHERE s.id = :data", Student.class
        );
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        manager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        Student student = manager.find(Student.class, id);
        manager.remove(student);
    }
}
