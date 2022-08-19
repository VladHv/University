package ua.foxminded.herasimov.university.dto.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dto.DtoMapper;
import ua.foxminded.herasimov.university.entity.Student;

@Component
public class StudentDtoMapper implements DtoMapper<StudentDto, Student> {

    private GroupDao groupDao;

    @Autowired
    public StudentDtoMapper(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Override
    public StudentDto toDto(Student entity) {
        return new StudentDto.Builder().withId(entity.getId())
                                       .withFirstName(entity.getFirstName())
                                       .withLastName(entity.getLastName())
                                       .withFaculty(entity.getFaculty())
                                       .withTicket(entity.getTicket())
                                       .withGroupId(entity.getGroup().getId())
                                       .build();
    }

    @Override
    public Student toEntity(StudentDto dto) {
        return new Student.Builder().withId(dto.getId())
                                    .withFirstName(dto.getFirstName())
                                    .withLastName(dto.getLastName())
                                    .withFaculty(dto.getFaculty())
                                    .withTicket(dto.getTicket())
                                    .withGroup(groupDao.findById(dto.getGroupId()).orElseThrow())
                                    .build();
    }
}
