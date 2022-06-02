package ua.foxminded.herasimov.university.entity;

import java.util.Objects;

public class Student extends Person{
    private String faculty;
    private Integer ticket;

    public Student(Integer id, String firstName, String lastName, String faculty, Integer ticket) {
        super(id, firstName, lastName);
        this.faculty = faculty;
        this.ticket = ticket;
    }

    public Student() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty) && Objects.equals(ticket, student.ticket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty, ticket);
    }
}
