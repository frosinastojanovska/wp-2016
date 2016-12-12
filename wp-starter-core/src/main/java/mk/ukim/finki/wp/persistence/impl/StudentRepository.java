package mk.ukim.finki.wp.persistence.impl;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.persistence.IStudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@Repository
public class StudentRepository implements IStudentRepository {
    public List<Student> findAll(){
        return null;
    }
    public Student findById(Integer id){
        return null;
    }
    public Student save(Student entity){
        return null;
    }
    public void update(Integer id, Student entity){

    }
    public void delete(Integer id){

    }
}
