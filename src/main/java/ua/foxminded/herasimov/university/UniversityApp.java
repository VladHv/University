package ua.foxminded.herasimov.university;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.foxminded.herasimov.university.config.SpringConfig;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.model.University;

import java.time.DayOfWeek;
import java.util.List;

public class UniversityApp {

    private static final Logger logger = LoggerFactory.getLogger(UniversityApp.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        University university = context.getBean(University.class);

        List<Timetable> timetables = university.getStudentTimetableForDay(1, DayOfWeek.MONDAY);

        timetables.forEach(timetable -> logger.info(timetable.toString()));


    }

}
