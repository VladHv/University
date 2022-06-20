package ua.foxminded.herasimov.university.service;

import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dao.TimetableDao;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityService {

    private TimetableDao timetableDao;
    private GroupDao groupDao;

    public UniversityService(TimetableDao timetableDao, GroupDao groupDao) {
        this.timetableDao = timetableDao;
        this.groupDao = groupDao;
    }

    public List<Timetable> getTeacherTimetableForDay(Integer teacherId, DayOfWeek day) {
        List<Timetable> monthTimetable = timetableDao.findAll();
        return monthTimetable.stream()
                             .filter(t -> t.getTeacherId().equals(teacherId))
                             .filter(t -> t.getDay().equals(day.getValue()))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getTeacherTimetableForMonth(Integer teacherId) {
        List<Timetable> monthTimetable = timetableDao.findAll();
        return monthTimetable.stream()
                             .filter(t -> t.getTeacherId().equals(teacherId))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForDay(Integer studentId, DayOfWeek day) {
        List<Timetable> monthTimetable = timetableDao.findAll();
        Integer groupId = groupDao.getGroupByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(groupId))
                             .filter(t -> t.getDay().equals(day.getValue()))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForMonth(Integer studentId) {
        List<Timetable> monthTimetable = timetableDao.findAll();
        Integer groupId = groupDao.getGroupByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(groupId))
                             .collect(Collectors.toList());
    }
}
