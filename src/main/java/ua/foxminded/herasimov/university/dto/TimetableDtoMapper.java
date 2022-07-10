package ua.foxminded.herasimov.university.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.foxminded.herasimov.university.dao.impl.GroupDaoImpl;
import ua.foxminded.herasimov.university.dao.impl.LessonDaoImpl;
import ua.foxminded.herasimov.university.dao.impl.TeacherDaoImpl;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.time.DayOfWeek;

@Component
public class TimetableDtoMapper {

    private GroupDaoImpl groupDao;
    private TeacherDaoImpl teacherDao;
    private LessonDaoImpl lessonDao;

    @Autowired
    public TimetableDtoMapper(GroupDaoImpl groupDao, TeacherDaoImpl teacherDao,
                              LessonDaoImpl lessonDao) {
        this.groupDao = groupDao;
        this.teacherDao = teacherDao;
        this.lessonDao = lessonDao;
    }

    public TimetableDto toDto(Timetable timetable) {
        return new TimetableDto.Builder().withId(timetable.getId())
                                         .withGroup(groupDao.findById(timetable.getGroupId()))
                                         .withTeacher(teacherDao.findById(timetable.getTeacherId()))
                                         .withLesson(lessonDao.findById(timetable.getLessonId()))
                                         .withDay(DayOfWeek.of(timetable.getDay()))
                                         .withTime(timetable.getTime())
                                         .build();
    }

    public Timetable toTimetable(TimetableDto dto) {
        return new Timetable.Builder().withId(dto.getId())
                                      .withGroupId(dto.getGroup().getId())
                                      .withTeacherId(dto.getTeacher().getId())
                                      .withLessonId(dto.getLesson().getId())
                                      .withDay(dto.getDay().getValue())
                                      .withTime(dto.getTime())
                                      .build();
    }

}
