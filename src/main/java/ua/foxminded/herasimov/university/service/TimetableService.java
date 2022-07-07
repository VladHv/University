package ua.foxminded.herasimov.university.service;

import ua.foxminded.herasimov.university.entity.Timetable;

import java.time.DayOfWeek;
import java.util.List;

public interface TimetableService extends Service<Integer, Timetable> {

    List<Timetable> getTeacherTimetableForDay(Integer teacherId, DayOfWeek day);

    List<Timetable> getTeacherTimetableForMonth(Integer teacherId);

    List<Timetable> getStudentTimetableForDay(Integer studentId, DayOfWeek day);

    List<Timetable> getStudentTimetableForMonth(Integer studentId);
}
