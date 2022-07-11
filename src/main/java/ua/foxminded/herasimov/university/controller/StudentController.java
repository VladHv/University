package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Student;
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
        model.addAttribute("student", new Student.Builder().build());
        return "students";
    }

    @PostMapping("/")
    public String createStudent(@ModelAttribute("student") Student student) {
        service.create(student);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/students/";
    }

    @GetMapping("/{id}")
    public String showStudentById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", service.findById(id).get());
        return "student_page";
    }

    @PostMapping("/{id}")
    public String updateStudent(@ModelAttribute("student") Student student) {
        service.update(student);
        return "redirect:/students/{id}";
    }
}
