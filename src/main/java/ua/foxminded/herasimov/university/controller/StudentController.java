package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.dto.impl.StudentDto;
import ua.foxminded.herasimov.university.dto.impl.StudentDtoMapper;
import ua.foxminded.herasimov.university.service.impl.GroupServiceImpl;
import ua.foxminded.herasimov.university.service.impl.StudentServiceImpl;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentServiceImpl studentService;
    private GroupServiceImpl groupService;
    private StudentDtoMapper dtoMapper;

    @Autowired
    public StudentController(StudentServiceImpl studentService,
                             GroupServiceImpl groupService,
                             StudentDtoMapper dtoMapper) {
        this.studentService = studentService;
        this.groupService = groupService;
        this.dtoMapper = dtoMapper;
    }

    @GetMapping("/")
    public String showStudents(Model model) {
        model.addAttribute("students", studentService.findAll());
        model.addAttribute("groups", groupService.findAll());
        model.addAttribute("student", new StudentDto.Builder().build());
        return "students";
    }

    @PostMapping("/")
    public String createStudent(@ModelAttribute("student") StudentDto studentDto) {
        studentService.create(dtoMapper.toEntity(studentDto));
        return "redirect:/students/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return "redirect:/students/";
    }

    @GetMapping("/{id}")
    public String showStudentById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("student", dtoMapper.toDto(studentService.findById(id)));
        model.addAttribute("groups", groupService.findAll());
        return "student_page";
    }

    @PostMapping("/{id}")
    public String updateStudent(@ModelAttribute("student") StudentDto studentDto) {
        studentService.update(dtoMapper.toEntity(studentDto));
        return "redirect:/students/{id}";
    }
}
