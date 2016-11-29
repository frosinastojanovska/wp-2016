package mk.ukim.finki.wp.model;

import java.util.Random;

/**
 * Created by Frosina on 28.11.2016.
 */
public class Group {
    private Long id;
    private String name;
    private Integer capacity;
    private Integer noExercise;

    public Group(){}

    public Group(Long id, String name, Integer capacity, Integer noExercise) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.noExercise = noExercise;
    }

    public Long getId() {
        return id;
    }

    public String getName() { return name; }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer getNoExercise() { return noExercise; }

    public void setId(Long id) {
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
}
