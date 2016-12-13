package mk.ukim.finki.wp.service;

import mk.ukim.finki.wp.model.Course;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
public interface ICourseService {
    List<Course> findAll();
    Course findById(Integer id);
    Course save(Course entity);
    void update(Integer id, Course entity);
    void delete(Integer id);
}
