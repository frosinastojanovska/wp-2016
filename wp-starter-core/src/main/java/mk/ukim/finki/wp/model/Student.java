package mk.ukim.finki.wp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by Frosina on 12.12.2016.
 */
@Entity
@Table(name = "lab_students")
public class Student {
    @Id
    private String index;
    @NotNull
    private String name;
    @NotNull
    private String surname;

    public Student(){}

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public enum FIELDS {
        INDEX {
            public String toString() {
                return "index";
            }
        },

        NAME {
            public String toString() {
                return "name";
            }
        },
        SURNAME{
            public String toString(){
                return "surname";
            }
        }
    }
}
