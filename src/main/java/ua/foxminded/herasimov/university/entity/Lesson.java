package ua.foxminded.herasimov.university.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "classroom")
    private Integer classroom;

    public static class Builder {
        private Lesson newLesson;

        public Builder() {
            newLesson = new Lesson();
        }

        public Builder withId(Integer id) {
            newLesson.id = id;
            return this;
        }

        public Builder withName(String name) {
            newLesson.name = name;
            return this;
        }

        public Builder withClassroom(Integer classroom) {
            newLesson.classroom = classroom;
            return this;
        }

        public Lesson build() {
            return newLesson;
        }
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

    @Override
    public String toString() {
        return "Lesson{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", classroom=" + classroom +
               '}';
    }
}
