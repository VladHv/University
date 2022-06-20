package ua.foxminded.herasimov.university.entity;

import java.util.Objects;

public class Lesson {

    private Integer id;
    private String name;
    private Integer classroom;

    public Lesson(Integer id, String name, Integer classroom) {
        this.id = id;
        this.name = name;
        this.classroom = classroom;
    }

    public Lesson() {
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

    public Integer getClassroom() {
        return classroom;
    }

    public void setClassroom(Integer classroom) {
        this.classroom = classroom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(name, lesson.name) && Objects.equals(classroom, lesson.classroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classroom);
    }
}
