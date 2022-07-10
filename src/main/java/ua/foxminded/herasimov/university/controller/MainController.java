package ua.foxminded.herasimov.university.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showAllTimetables() {
        return "index";
    }

}
