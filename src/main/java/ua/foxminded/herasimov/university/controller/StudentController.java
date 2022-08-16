package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Student;
import ua.foxminded.herasimov.university.service.impl.GroupServiceImpl;
import ua.foxminded.herasimov.university.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentServiceImpl studentService;
    private GroupServiceImpl groupService;

    @Autowired
    public StudentController(StudentServiceImpl studentService,
                             GroupServiceImpl groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.findAll().get());
        model.addAttribute("groups", groupService.findAll().get());
        model.addAttribute("student", new Student.Builder().build());
        return "students";
    }

    @PostMapping("/")
    public String createStudent(@ModelAttribute("student") Student student) {
        studentService.create(student);
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return "redirect:/students/";
    }

    @GetMapping("/{id}")
    public String showStudentById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", studentService.findById(id).get());
        return "student_page";
    }

    @PostMapping("/{id}")
    public String updateStudent(@ModelAttribute("student") Student student) {
        studentService.update(student);
        return "redirect:/students/{id}";
    }
}
