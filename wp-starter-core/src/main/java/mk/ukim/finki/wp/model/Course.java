package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Frosina on 12.12.2016.
 */
@Entity
@Table(name = "lab_courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique=true)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_dependency_id")
    public Course courseDependency;

    public Course(){}

    public Course(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourseDependency() {
        return courseDependency;
    }

    public void setCourseDependency(Course courseDependency) {
        this.courseDependency = courseDependency;
    }

    public enum FIELDS {
        ID {
            public String toString() {
                return "id";
            }
        },

        NAME {
            public String toString() {
                return "name";
            }
        },
        DEPENDECNY{
            public String toString(){
                return "courseDependency";
            }
        }
    }
}
