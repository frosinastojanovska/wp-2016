package mk.ukim.finki.wp.model;

import javax.persistence.*;

/**
 * Created by Frosina on 12.12.2016.
 */
@Entity
@Table(name = "lab_student_course_association")
public class StudentCourseAssociation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;

    public StudentCourseAssociation(){}

    public StudentCourseAssociation(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}