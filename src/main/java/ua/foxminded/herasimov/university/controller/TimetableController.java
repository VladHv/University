package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.dto.impl.TimetableDto;
import ua.foxminded.herasimov.university.dto.impl.TimetableDtoMapper;
import ua.foxminded.herasimov.university.service.impl.GroupServiceImpl;
import ua.foxminded.herasimov.university.service.impl.LessonServiceImpl;
import ua.foxminded.herasimov.university.service.impl.TeacherServiceImpl;
import ua.foxminded.herasimov.university.service.impl.TimetableServiceImpl;

import java.time.DayOfWeek;

@Controller
@RequestMapping("/timetables")
public class TimetableController {

    private TimetableServiceImpl timetableService;
    private LessonServiceImpl lessonService;
    private TeacherServiceImpl teacherService;
    private GroupServiceImpl groupService;
    private TimetableDtoMapper dtoMapper;

    @Autowired
    public TimetableController(TimetableServiceImpl timetableService,
                               LessonServiceImpl lessonService,
                               TeacherServiceImpl teacherService,
                               GroupServiceImpl groupService,
                               TimetableDtoMapper dtoMapper) {
        this.timetableService = timetableService;
        this.lessonService = lessonService;
        this.teacherService = teacherService;
        this.groupService = groupService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/")
    public String showAllTimetables(Model model) {
        model.addAttribute("timetables", timetableService.findAll());
        model.addAttribute("timetable", new TimetableDto.Builder().build());
        model.addAttribute("lessonsList", lessonService.findAll());
        model.addAttribute("teachersList", teacherService.findAll());
        model.addAttribute("groupsList", groupService.findAll());
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        return "timetable";
    }

    @PostMapping("/")
    public String createTimetable(@ModelAttribute("timetable") TimetableDto timetableDto) {
        timetableService.create(dtoMapper.toEntity(timetableDto));
        return "redirect:/timetables/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTimetable(@PathVariable("id") Integer id) {
        timetableService.delete(id);
        return "redirect:/timetables/";
    }

    @GetMapping("/{id}")
    public String showTimetableById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("timetable", dtoMapper.toDto(timetableService.findById(id)));
        model.addAttribute("lessonsList", lessonService.findAll());
        model.addAttribute("teachersList", teacherService.findAll());
        model.addAttribute("groupsList", groupService.findAll());
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        return "timetable_page";
    }

    @PostMapping("/{id}")
    public String updateTimetable(@ModelAttribute("timetable") TimetableDto timetableDto) {
        timetableService.update(dtoMapper.toEntity(timetableDto));
        return "redirect:/timetables/{id}";
    }
}
