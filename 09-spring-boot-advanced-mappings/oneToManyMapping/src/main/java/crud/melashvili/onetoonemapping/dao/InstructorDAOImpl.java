package crud.melashvili.onetoonemapping.dao;

import crud.melashvili.onetoonemapping.entity.Course;
import crud.melashvili.onetoonemapping.entity.Instructor;
import crud.melashvili.onetoonemapping.entity.InstructorDetail;
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
        InstructorDetail temp = manager.find(InstructorDetail.class, id);
        temp.getInstructor().setInstructorDetail(null);
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
    public void updateInstructor(Instructor temp) {
        manager.merge(temp);
    }
}
