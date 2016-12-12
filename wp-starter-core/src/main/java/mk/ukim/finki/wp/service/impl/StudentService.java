package mk.ukim.finki.wp.service.impl;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.IStudentRepository;
import mk.ukim.finki.wp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Service
public class StudentService implements IStudentService{

    private IStudentRepository repository;

    @Autowired
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> findAll(){
        return repository.findAll();
    }
    public Student findById(Integer id){
        return repository.findById(id);
    }
    public Student save(Student entity){
        return repository.save(entity);
    }
    public void update(Integer id, Student entity){
        repository.update(id, entity);
    }
    public void delete(Integer id){
        repository.delete(id);
    }
}
