package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.events.StudentEnrolledInCourse;
import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.persistence.IStudentRepository;
import mk.ukim.finki.wp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Service
public class StudentService implements IStudentService {

    private IStudentRepository repository;

    private ApplicationEventPublisher publisher;

    @Autowired
    public StudentService(IStudentRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student findByIndex(Integer index) {
        return repository.findByIndex(index);
    }

    public Student save(Student entity) {
        return repository.save(entity);
    }

    public void update(Integer id, Student entity) {
        repository.update(id, entity);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public void addCourse(StudentCourseAssociation entity){
        repository.addStudentToCourse(entity);
    }


    public void publishExample() {
        publisher.publishEvent(new StudentEnrolledInCourse(null, null));
    }
}
