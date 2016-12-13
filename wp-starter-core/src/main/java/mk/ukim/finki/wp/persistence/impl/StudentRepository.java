package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.IStudentRepository;
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
public class StudentRepository implements IStudentRepository {

    @PersistenceContext(name = "wp")
    private EntityManager entityManager;

    public List<Student> findAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> from = query.from(Student.class);
        query.select(from);
        TypedQuery<Student> q = entityManager.createQuery(query);
        return q.getResultList();
    }
    public Student findByIndex(Integer index){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> query = cb.createQuery(Student.class);
        Root<Student> from = query.from(Student.class);
        query.select(from);
        query.select(from).where(cb.equal(from.get(Student.FIELDS.INDEX.toString()), index));
        TypedQuery<Student> q = entityManager.createQuery(query);
        q.setParameter(index, index);
        return q.getSingleResult();
    }
    @Transactional
    public Student save(Student entity){
        entityManager.persist(entity);
        entityManager.flush();
        return entity;
    }
    @Transactional
    public void update(Integer index, Student entity){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Student> update = cb.createCriteriaUpdate(Student.class);
        Root<Student> from = update.from(Student.class);
        update.set(Student.FIELDS.NAME.toString(), entity.getName());
        update.set(Student.FIELDS.SURNAME.toString(), entity.getSurname());
        update.where(cb.equal(from.get(Student.FIELDS.INDEX.toString()),index));

        entityManager.createQuery(update).executeUpdate();
    }
    @Transactional
    public void delete(Integer index){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaDelete<Student> delete = cb.createCriteriaDelete(Student.class);
        Root<Student> from = delete.from(Student.class);

        delete.where(cb.equal(from.get(Student.FIELDS.INDEX.toString()), index));

        entityManager.createQuery(delete).executeUpdate();
    }
}
