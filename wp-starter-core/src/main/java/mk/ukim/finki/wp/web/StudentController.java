package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Student;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@RestController
@RequestMapping(value = "/api/students", produces = "application/json")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Student> findAll(){
        List<Student> res = studentService.findAll();
        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Student findByIndex(@PathVariable Integer id){
        return studentService.findByIndex(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addCourse")
    public void addStudentToCourse(@RequestBody StudentCourseAssociation entity){
        studentService.addCourse(entity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody Student student){
        studentService.update(id, student);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id){
        studentService.delete(id);
    }
}
