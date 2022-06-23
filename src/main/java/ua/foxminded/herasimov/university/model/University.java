package ua.foxminded.herasimov.university.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.service.GroupService;
import ua.foxminded.herasimov.university.service.TimetableService;

import java.time.DayOfWeek;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class University {

    private TimetableService timetableService;
    private GroupService groupService;

    @Autowired
    public University(TimetableService timetableService,
                      GroupService groupService) {
        this.timetableService = timetableService;
        this.groupService = groupService;
    }

    public List<Timetable> getTeacherTimetableForDay(Integer teacherId, DayOfWeek day) {
        List<Timetable> monthTimetable = timetableService.findAll();
        return monthTimetable.stream()
                             .filter(t -> t.getTeacherId().equals(teacherId))
                             .filter(t -> t.getDay().equals(day.getValue()))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getTeacherTimetableForMonth(Integer teacherId) {
        List<Timetable> monthTimetable = timetableService.findAll();
        return monthTimetable.stream()
                             .filter(t -> t.getTeacherId().equals(teacherId))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForDay(Integer studentId, DayOfWeek day) {
        List<Timetable> monthTimetable = timetableService.findAll();
        Group group = groupService.getGroupByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(group.getId()))
                             .filter(t -> t.getDay().equals(day.getValue()))
                             .collect(Collectors.toList());
    }

    public List<Timetable> getStudentTimetableForMonth(Integer studentId) {
        List<Timetable> monthTimetable = timetableService.findAll();
        Group group = groupService.getGroupByStudentId(studentId);
        return monthTimetable.stream()
                             .filter(t -> t.getGroupId().equals(group.getId()))
                             .collect(Collectors.toList());
    }
}
