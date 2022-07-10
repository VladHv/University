package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String showLessons(Model model){
        model.addAttribute("lessons", service.findAll().get());
        return "lessons";
    }
}
