package mk.ukim.finki.wp.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Frosina on 28.11.2016.
 */
@Entity
@Table(name = "lab_groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String name;
    @Min(value = 0)
    private Integer capacity;
    @Min(value = 0)
    private Integer noExercise;

    public Group(){}

    public Group(Integer id, String name, Integer capacity, Integer noExercise) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.noExercise = noExercise;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getNoExercise() {
        return noExercise;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setNoExercise(Integer noExercise) {
        this.noExercise = noExercise;
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
        CAPACITY{
            public String toString(){
                return "capacity";
            }
        },
        NO_EXERCISE{
            public String toString(){
                return "noExercise";
            }
        }
    }
}
