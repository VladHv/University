package ua.foxminded.herasimov.university.model;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class University {
    private List<Timetable> monthTimetables;

    public University(List<Timetable> monthTimetables) {
        this.monthTimetables = monthTimetables;
    }

    public University() {
    }

    public List<Timetable> getTeacherTimetableForDay(Integer teacherId, DayOfWeek day) {
        return monthTimetables.stream()
                              .filter(t -> t.getTeacher().getId().equals(teacherId))
                              .filter(t -> t.getDay().equals(day))
                              .collect(Collectors.toList());
    }

    public List<Timetable> getTeacherTimetableForMonth(Integer teacherId) {
        return monthTimetables.stream()
                              .filter(t -> t.getTeacher().getId().equals(teacherId))
                              .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForDay(Integer studentId, DayOfWeek day) {
        return monthTimetables.stream()
                       .filter(t -> t.getStudentIds().contains(studentId))
                       .filter(t -> t.getDay().equals(day))
                       .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForMonth(Integer studentId) {
        return monthTimetables.stream()
                              .filter(t -> t.getStudentIds().contains(studentId))
                              .collect(Collectors.toList());
    }


    public List<Timetable> getMonthTimetables() {
        return monthTimetables;
    }

    public void setMonthTimetables(List<Timetable> monthTimetables) {
        this.monthTimetables = monthTimetables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(monthTimetables, that.monthTimetables);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monthTimetables);
    }
}
