package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Group;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.entity.Teacher;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.service.impl.GroupServiceImpl;
import ua.foxminded.herasimov.university.service.impl.LessonServiceImpl;
import ua.foxminded.herasimov.university.service.impl.TeacherServiceImpl;
import ua.foxminded.herasimov.university.service.impl.TimetableServiceImpl;

import java.time.DayOfWeek;
import java.util.List;

@Controller
@RequestMapping("/timetables")
public class TimetableController {

    private TimetableServiceImpl timetableService;
    private LessonServiceImpl lessonService;
    private TeacherServiceImpl teacherService;
    private GroupServiceImpl groupService;

    @Autowired
    public TimetableController(TimetableServiceImpl timetableService,
                               LessonServiceImpl lessonService,
                               TeacherServiceImpl teacherService,
                               GroupServiceImpl groupService) {
        this.timetableService = timetableService;
        this.lessonService = lessonService;
        this.teacherService = teacherService;
        this.groupService = groupService;
    }

    @GetMapping("/")
    public String showAllTimetables(Model model) {
        List<Timetable> timetables = timetableService.findAll().get();
        List<Lesson> lessons = lessonService.findAll().get();
        List<Teacher> teachers = teacherService.findAll().get();
        List<Group> groups = groupService.findAll().get();
        model.addAttribute("timetables", timetables);
        model.addAttribute("timetable", new Timetable.Builder().build());
        model.addAttribute("lessonsList", lessons);
        model.addAttribute("teachersList", teachers);
        model.addAttribute("groupsList", groups);
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        return "timetable";
    }

    @PostMapping("/")
    public String createTimetable(@ModelAttribute("timetable") Timetable timetable) {
        timetableService.create(timetable);
        return "redirect:/timetables/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTimetable(@PathVariable("id") Integer id) {
        timetableService.delete(id);
        return "redirect:/timetables/";
    }

    @GetMapping("/{id}")
    public String showTimetableById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("timetable", timetableService.findById(id).get());
        List<Lesson> lessons = lessonService.findAll().get();
        List<Teacher> teachers = teacherService.findAll().get();
        List<Group> groups = groupService.findAll().get();
        model.addAttribute("lessonsList", lessons);
        model.addAttribute("teachersList", teachers);
        model.addAttribute("groupsList", groups);
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        return "timetable_page";
    }

    @PostMapping("/{id}")
    public String updateTimetable(@ModelAttribute("timetable") Timetable timetable) {
        timetableService.update(timetable);
        return "redirect:/timetables/{id}";
    }
}
