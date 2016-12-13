package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
public interface IStudentRepository {
    List<Student> findAll();
    Student findByIndex(Integer id);
    Student save(Student entity);
    void update(Integer id, Student entity);
    void delete(Integer id);
    void addStudentToCourse(StudentCourseAssociation entity);
}
