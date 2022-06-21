package ua.foxminded.herasimov.university.service;

import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.dao.impl.TimetableDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityService {

    private TimetableDaoImpl timetableDao;
    private GroupDaoImpl groupDao;

    public UniversityService(TimetableDaoImpl timetableDao, GroupDaoImpl groupDao) {
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
        Integer groupId = groupDao.getGroupIdByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(groupId))
                             .filter(t -> t.getDay().equals(day.getValue()))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForMonth(Integer studentId) {
        List<Timetable> monthTimetable = timetableDao.findAll();
        Integer groupId = groupDao.getGroupIdByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(groupId))
                             .collect(Collectors.toList());
    }
}
