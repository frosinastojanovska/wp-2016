package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
public interface IStudentRepository {
    List<Student> findAll();
    Student findById(Integer id);
    Student save(Student entity);
    void update(Integer id, Student entity);
    void delete(Integer id);
}
