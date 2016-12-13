package mk.ukim.finki.wp.events;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Frosina on 13.12.2016.
 */
public class StudentEnrolledInCourse extends ApplicationEvent {

    Student student;
    Course course;

    public StudentEnrolledInCourse(Student student, Course course) {
        super(student);

        this.student = student;
        this.course = course;
    }


}
