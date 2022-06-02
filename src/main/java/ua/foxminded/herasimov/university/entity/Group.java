package ua.foxminded.herasimov.university.entity;

import java.util.List;
import java.util.Objects;

public class Group {
    private Integer id;
    private List<Student> students;

    public Group(Integer id, List<Student> students) {
        this.id = id;
        this.students = students;
    }

    public Group() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, students);
    }
}
