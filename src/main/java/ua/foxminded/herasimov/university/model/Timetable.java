package ua.foxminded.herasimov.university.model;

import ua.foxminded.herasimov.university.entity.*;

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

    public Timetable(LocalTime time, Lesson lesson, Teacher teacher, Group group, DayOfWeek day) {
        this.time = time;
        this.lesson = lesson;
        this.teacher = teacher;
        this.group = group;
        this.day = day;
    }

    public List<Integer> getStudentIds(){
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
