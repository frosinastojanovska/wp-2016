package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.persistence.ICourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Repository
public class CourseRepository implements ICourseRepository {
    public List<Course> findAll(){
        return null;
    }
    public Course findById(Integer id){
        return null;
    }
    public Course save(Course entity){
        return null;
    }
    public void update(Integer id, Course entity){

    }
    public void delete(Integer id){

    }
}
