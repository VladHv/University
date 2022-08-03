package ua.foxminded.herasimov.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Column(name = "department")
    private String department;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "position")
    private TeacherPosition position;

    protected Teacher() {
    }

    public static final class Builder extends Person.ABuilder<Teacher, Builder> {

        @Override
        protected Teacher getObject() {
            return new Teacher();
        }

        @Override
        protected Builder thisObject() {
            return this;
        }

        public Builder withDepartment(String department) {
            object.department = department;
            return this;
        }

        public Builder withPosition(TeacherPosition position) {
            object.position = position;
            return this;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public TeacherPosition getPosition() {
        return position;
    }

    public void setPosition(TeacherPosition position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(department, teacher.department) && position == teacher.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department, position);
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", department='" + department + '\'' +
               ", position=" + position +
               '}';
    }
}
