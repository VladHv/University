package ua.foxminded.herasimov.university.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "ticket")
    private Integer ticket;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private Group group;

    protected Student() {
    }

    public static final class Builder extends Person.ABuilder<Student, Builder> {

        @Override
        protected Student getObject() {
            return new Student();
        }

        @Override
        protected Builder thisObject() {
            return this;
        }

        public Builder withFaculty(String faculty) {
            object.faculty = faculty;
            return this;
        }

        public Builder withTicket(Integer ticket) {
            object.ticket = ticket;
            return this;
        }

        public Builder withGroup(Group group) {
            object.group = group;
            return this;
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty) && Objects.equals(ticket, student.ticket) &&
               Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, ticket, group);
    }

    @Override
    public String toString() {
        return "Student{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", faculty='" + faculty + '\'' +
               ", ticket=" + ticket +
               ", group=" + group +
               '}';
    }
}
