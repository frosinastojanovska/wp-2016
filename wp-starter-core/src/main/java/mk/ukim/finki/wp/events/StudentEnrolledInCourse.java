package mk.ukim.finki.wp.events;

import mk.ukim.finki.wp.model.Course;
import mk.ukim.finki.wp.model.Student;
import org.springframework.context.ApplicationEvent;

/**
 * Created by Frosina on 13.12.2016.
 */
public class StudentEnrolledInCourse extends ApplicationEvent {

    private Student student;
    private Course course;

    public StudentEnrolledInCourse(Student student, Course course) {
        super(student);

        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
