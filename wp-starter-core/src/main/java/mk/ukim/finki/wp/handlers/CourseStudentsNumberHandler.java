package mk.ukim.finki.wp.handlers;

import mk.ukim.finki.wp.events.StudentEnrolledInCourse;
import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.StudentCourseAssociation;
import mk.ukim.finki.wp.persistence.ICourseRepository;
import mk.ukim.finki.wp.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Frosina on 13.12.2016.
 */
@Component
public class CourseStudentsNumberHandler implements ApplicationListener{

    private ICourseService courseService;

    @Autowired
    public CourseStudentsNumberHandler(ICourseService courseService){
        this.courseService = courseService;
    }

    //@Override
    public void onApplicationEvent(StudentEnrolledInCourse studentEnrolledInCourse) {
        Course course = studentEnrolledInCourse.getCourse();
        courseService.incrementNumOfStudents(course);
        System.out.println();
        System.out.println("=====Faten event=====");
    }

    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(ApplicationEvent.class.equals(StudentEnrolledInCourse.class)){
            StudentEnrolledInCourse studentEnrolledInCourse = (StudentEnrolledInCourse) applicationEvent;
            Course course = studentEnrolledInCourse.getCourse();
            courseService.incrementNumOfStudents(course);
            System.out.println();
            System.out.println("=====Faten event=====");

        }
    }
}
