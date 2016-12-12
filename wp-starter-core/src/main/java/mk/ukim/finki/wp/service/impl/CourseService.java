package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.persistence.ICourseRepository;
import mk.ukim.finki.wp.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Repository
public class CourseService implements ICourseService {

    private ICourseRepository repository;

    @Autowired
    public CourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> findAll(){
        return repository.findAll();
    }
    public Course findById(Integer id){
        return repository.findById(id);
    }
    public Course save(Course entity){
        return repository.save(entity);
    }
    public void update(Integer id, Course entity){
        repository.update(id, entity);
    }
    public void delete(Integer id){
        repository.delete(id);
    }
}
