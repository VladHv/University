package ua.foxminded.herasimov.university.entity;

import java.util.List;
import java.util.Objects;

public class Group {
    private Integer id;
    private String name;
    private List<Student> students;

    public static class Builder {
        private Group newGroup;

        public Builder() {
            newGroup = new Group();
        }

        public Builder withId(Integer id) {
            newGroup.id = id;
            return this;
        }

        public Builder withName(String name) {
            newGroup.name = name;
            return this;
        }

        public Builder withStudents(List<Student> students) {
            newGroup.students = students;
            return this;
        }

        public Group build() {
            return newGroup;
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
        return Objects.equals(id, group.id) && Objects.equals(name, group.name) &&
               Objects.equals(students, group.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, students);
    }

    @Override
    public String toString() {
        return "Group{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", students=" + students +
               '}';
    }
}
