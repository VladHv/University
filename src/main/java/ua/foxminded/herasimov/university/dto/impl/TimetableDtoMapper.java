package ua.foxminded.herasimov.university.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dao.LessonDao;
import ua.foxminded.herasimov.university.dao.TeacherDao;
import ua.foxminded.herasimov.university.dto.DtoMapper;
import ua.foxminded.herasimov.university.entity.Timetable;

import java.time.DayOfWeek;

@Component
public class TimetableDtoMapper implements DtoMapper<TimetableDto, Timetable> {

    private GroupDao groupDao;
    private TeacherDao teacherDao;
    private LessonDao lessonDao;

    @Autowired
    public TimetableDtoMapper(GroupDao groupDao, TeacherDao teacherDao,
                              LessonDao lessonDao) {
        this.groupDao = groupDao;
        this.teacherDao = teacherDao;
        this.lessonDao = lessonDao;
    }

    @Override
    public TimetableDto toDto(Timetable entity) {
        return new TimetableDto.Builder().withId(entity.getId())
                                         .withGroupId(entity.getGroup().getId())
                                         .withTeacherId(entity.getTeacher().getId())
                                         .withLessonId(entity.getLesson().getId())
                                         .withDay(entity.getDay().getValue())
                                         .withTime(entity.getTime())
                                         .build();
    }

    @Override
    public Timetable toEntity(TimetableDto dto) {
        return new Timetable.Builder().withId(dto.getId())
                                      .withGroup(groupDao.findById(dto.getGroupId()).orElseThrow())
                                      .withTeacher(teacherDao.findById(dto.getTeacherId()).orElseThrow())
                                      .withLesson(lessonDao.findById(dto.getLessonId()).orElseThrow())
                                      .withDay(DayOfWeek.of(dto.getDay()))
                                      .withTime(dto.getTime())
                                      .build();
    }
}
