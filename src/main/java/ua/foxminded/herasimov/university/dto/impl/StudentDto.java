package ua.foxminded.herasimov.university.dto.impl;

import ua.foxminded.herasimov.university.dto.Dto;

public class StudentDto implements Dto {

    private Integer id;
    private String firstName;
    private String lastName;
    private String faculty;
    private Integer ticket;
    private Integer groupId;

    public StudentDto() {
    }

    public StudentDto(Integer id, String firstName, String lastName, String faculty, Integer ticket,
                      Integer groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.ticket = ticket;
        this.groupId = groupId;
    }

    public static class Builder {
        private StudentDto newDto;


        public Builder() {
            newDto = new StudentDto();
        }

        public Builder withId(Integer id) {
            newDto.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            newDto.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            newDto.lastName = lastName;
            return this;
        }

        public Builder withFaculty(String faculty) {
            newDto.faculty = faculty;
            return this;
        }

        public Builder withTicket(Integer ticket) {
            newDto.ticket = ticket;
            return this;
        }

        public Builder withGroupId(Integer groupId) {
            newDto.groupId = groupId;
            return this;
        }

        public StudentDto build() {
            return newDto;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", faculty='" + faculty + '\'' +
               ", ticket=" + ticket +
               ", groupId=" + groupId +
               '}';
    }
}
