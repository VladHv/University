package ua.foxminded.herasimov.university.entity;

import java.util.Objects;

public class Teacher extends Person {
    private String department;
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
}
