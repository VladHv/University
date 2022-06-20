package ua.foxminded.herasimov.university;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.foxminded.herasimov.university.config.SpringConfig;
import ua.foxminded.herasimov.university.dao.GroupDao;
import ua.foxminded.herasimov.university.dao.TimetableDao;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.service.UniversityService;

import java.time.DayOfWeek;
import java.util.List;

public class UniversityApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        TimetableDao timetableDao = context.getBean(TimetableDao.class);
        GroupDao groupDao = context.getBean(GroupDao.class);

        UniversityService service = new UniversityService(timetableDao, groupDao);

        List<Timetable> timetables = service.getStudentTimetableForDay(1, DayOfWeek.MONDAY);

        timetables.forEach(System.out::println);



    }

}
