package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Lesson;
import ua.foxminded.herasimov.university.service.impl.LessonServiceImpl;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private LessonServiceImpl service;

    @Autowired
    public LessonController(LessonServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showLessons(Model model) {
        model.addAttribute("lessons", service.findAll().get());
        model.addAttribute("lesson", new Lesson.Builder().build());
        return "lessons";
    }

    @PostMapping("/")
    public String createLesson(@ModelAttribute("lesson") Lesson lesson) {
        service.create(lesson);
        return "redirect:/lessons/";
    }

    @GetMapping("/delete/{id}")
    public String deleteLesson(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/lessons/";
    }

    @GetMapping("/{id}")
    public String showLessonById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("lesson", service.findById(id).get());
        return "lesson_page";
    }

    @PostMapping("/{id}")
    public String updateLesson(@ModelAttribute("lesson") Lesson lesson) {
        service.update(lesson);
        return "redirect:/lessons/{id}";
    }
}
