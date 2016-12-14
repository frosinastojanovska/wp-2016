package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.ICourseRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Repository
public class CourseRepository implements ICourseRepository {

    @PersistenceContext(name = "wp")
    private EntityManager entityManager;

    public List<Course> findAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> from = query.from(Course.class);
        query.select(from);
        TypedQuery<Course> q = entityManager.createQuery(query);
        return q.getResultList();
    }
    public Course findById(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> query = cb.createQuery(Course.class);
        Root<Course> from = query.from(Course.class);
        query.select(from);
        query.select(from).where(cb.equal(from.get(Course.FIELDS.ID.toString()), id));
        TypedQuery<Course> q = entityManager.createQuery(query);
        return q.getSingleResult();
    }
    @Transactional
    public Course save(Course entity){
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }
    @Transactional
    public void update(Integer id, Course entity){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Course> update = cb.createCriteriaUpdate(Course.class);
        Root<Course> from = update.from(Course.class);
        update.set(Course.FIELDS.NAME.toString(), entity.getName());
        update.set(Course.FIELDS.DEPENDECNY.toString(), entity.getCourseDependency());
        update.where(cb.equal(from.get(Course.FIELDS.ID.toString()),id));

        entityManager.createQuery(update).executeUpdate();
    }
    @Transactional
    public void delete(Integer id){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Course> delete = cb.createCriteriaDelete(Course.class);
        Root<Course> from = delete.from(Course.class);

        delete.where(cb.equal(from.get(Course.FIELDS.ID.toString()), id));

        entityManager.createQuery(delete).executeUpdate();
    }

    public List<Student> getAssignedStudents(Integer id){
        TypedQuery<Student> q = entityManager.createQuery("SELECT s.student FROM StudentCourseAssociation s WHERE s.course.id = :id", Student.class);
        return q.setParameter("id", id).getResultList();
    }

    public  List<Student> getUnassignedStudents(Integer id){
        TypedQuery<Student> q = entityManager.createQuery("SELECT s FROM Student s WHERE s NOT IN (SELECT sc.student FROM StudentCourseAssociation sc WHERE sc.course.id = :id)", Student.class);
        return q.setParameter("id", id).getResultList();
    }
}
