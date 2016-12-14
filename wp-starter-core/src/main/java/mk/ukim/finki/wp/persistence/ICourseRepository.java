package mk.ukim.finki.wp.persistence;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
public interface ICourseRepository {
    List<Course> findAll();
    Course findById(Integer id);
    Course save(Course entity);
    void update(Integer id, Course entity);
    void delete(Integer id);
    List<Student> getAssignedStudents(Integer id);
}
