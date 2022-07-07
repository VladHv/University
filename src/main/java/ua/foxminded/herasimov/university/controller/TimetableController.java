package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.foxminded.herasimov.university.service.impl.TimetableServiceImpl;

@Controller
public class TimetableController {

    private TimetableServiceImpl service;

    @Autowired
    public TimetableController(TimetableServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showAllTimetables(Model model) {
        model.addAttribute("timetables", service.findAll().get());
        return "index";
    }

}
