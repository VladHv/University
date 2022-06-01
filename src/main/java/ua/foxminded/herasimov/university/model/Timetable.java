package ua.foxminded.herasimov.university.model;

import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.entity.Person;
import ua.foxminded.herasimov.university.entity.Teacher;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Timetable {
    private LocalTime time;
    private Lesson lesson;
    private Teacher teacher;
    private Group group;
    private DayOfWeek day;
    
    public static class Builder {
        private Timetable newTimetable;

        public Builder() {
            newTimetable = new Timetable();
        }

        public Builder withTime(LocalTime time) {
            newTimetable.time = time;
            return this;
        }

        public Builder withLesson(Lesson lesson) {
            newTimetable.lesson = lesson;
            return this;
        }

        public Builder withTeacher(Teacher teacher) {
            newTimetable.teacher = teacher;
            return this;
        }

        public Builder withGroup(Group group) {
            newTimetable.group = group;
            return this;
        }

        public Builder withDay(DayOfWeek day) {
            newTimetable.day = day;
            return this;
        }

        public Timetable build() {
            return newTimetable;
        }
    }

    public List<Integer> getStudentIds() {
        return group.getStudents().stream().map(Person::getId).collect(Collectors.toList());
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(time, timetable.time) && Objects.equals(lesson, timetable.lesson) &&
               Objects.equals(teacher, timetable.teacher) && Objects.equals(group, timetable.group) &&
               day == timetable.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(time, lesson, teacher, group, day);
    }
}
