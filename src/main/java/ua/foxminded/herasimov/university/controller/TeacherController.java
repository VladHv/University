package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("teachers", service.findAll().get());
        return "teachers";
    }
}
