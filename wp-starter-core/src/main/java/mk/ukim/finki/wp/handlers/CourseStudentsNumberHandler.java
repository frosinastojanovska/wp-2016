package mk.ukim.finki.wp.handlers;

import mk.ukim.finki.wp.events.StudentEnrolledInCourse;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Frosina on 13.12.2016.
 */
@Component
public class CourseStudentsNumberHandler implements ApplicationListener<StudentEnrolledInCourse> {
    public void onApplicationEvent(StudentEnrolledInCourse studentEnrolledInCourse) {
        // do your logic

    }
}
