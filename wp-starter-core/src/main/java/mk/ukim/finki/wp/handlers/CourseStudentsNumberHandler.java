package mk.ukim.finki.wp.handlers;

import mk.ukim.finki.wp.events.StudentEnrolledInCourse;
import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.persistence.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Frosina on 13.12.2016.
 */
@Component
public class CourseStudentsNumberHandler implements ApplicationListener<StudentEnrolledInCourse> {

    private ICourseRepository repository;

    @Autowired
    public CourseStudentsNumberHandler(ICourseRepository repository){
        this.repository = repository;
    }

    public void onApplicationEvent(StudentEnrolledInCourse studentEnrolledInCourse) {
        // do your logic
        Course course = studentEnrolledInCourse.getCourse();
        course.setNumOfStudents(course.getNumOfStudents() + 1);
        repository.update(course.getId(), course);
    }
}
