package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Teacher;
import ua.foxminded.herasimov.university.entity.TeacherPosition;
import ua.foxminded.herasimov.university.service.impl.TeacherServiceImpl;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private TeacherServiceImpl service;

    @Autowired
    public TeacherController(TeacherServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showTeachers(Model model) {
        model.addAttribute("teachers", service.findAll());
        model.addAttribute("teacher", new Teacher.Builder().build());
        model.addAttribute("positions", TeacherPosition.values());
        return "teachers";
    }

    @PostMapping("/")
    public String createTeacher(@ModelAttribute("teacher") Teacher teacher) {
        service.create(teacher);
        return "redirect:/teachers/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/teachers/";
    }

    @GetMapping("/{id}")
    public String showTeacherById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("teacher", service.findById(id));
        model.addAttribute("positions", TeacherPosition.values());
        return "teacher_page";
    }

    @PostMapping("/{id}")
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher) {
        service.update(teacher);
        return "redirect:/teachers/{id}";
    }
}
