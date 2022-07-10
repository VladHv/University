package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.foxminded.herasimov.university.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

    StudentServiceImpl service;

    @Autowired
    public StudentController(StudentServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("students", service.findAll().get());
        return "students";
    }
}
