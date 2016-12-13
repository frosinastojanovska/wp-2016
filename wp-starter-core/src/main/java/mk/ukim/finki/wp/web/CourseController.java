package mk.ukim.finki.wp.web;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Frosina on 12.12.2016.
 */
@RestController
@RequestMapping(value = "/api/courses", produces = "application/json")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Course> findAll(){
        List<Course> res = courseService.findAll();
        return res;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Course findById(@PathVariable Integer id){
        return courseService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Course save(@RequestBody Course group){
        return courseService.save(group);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody Course group){
        courseService.update(id, group);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable Integer id){
        courseService.delete(id);
    }
}
