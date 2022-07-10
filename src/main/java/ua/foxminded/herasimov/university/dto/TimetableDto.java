package ua.foxminded.herasimov.university.dto;

import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.entity.Teacher;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class TimetableDto {

    private Integer id;
    private Lesson lesson;
    private Teacher teacher;
    private Group group;
    private DayOfWeek day;
    private LocalTime time;

    public static class Builder {
        private TimetableDto newDto;

        public Builder() {
            newDto = new TimetableDto();
        }

        public Builder withId(Integer id) {
            newDto.id = id;
            return this;
        }

        public Builder withTime(LocalTime time) {
            newDto.time = time;
            return this;
        }

        public Builder withLesson(Lesson lesson) {
            newDto.lesson = lesson;
            return this;
        }

        public Builder withTeacher(Teacher teacher) {
            newDto.teacher = teacher;
            return this;
        }

        public Builder withGroup(Group group) {
            newDto.group = group;
            return this;
        }

        public Builder withDay(DayOfWeek day) {
            newDto.day = day;
            return this;
        }

        public TimetableDto build() {
            return newDto;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
