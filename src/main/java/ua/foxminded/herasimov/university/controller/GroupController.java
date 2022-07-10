package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.foxminded.herasimov.university.service.impl.GroupServiceImpl;

@Controller
@RequestMapping("/groups")
public class GroupController {

    private GroupServiceImpl service;

    @Autowired
    public GroupController(GroupServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showGroups(Model model){
        model.addAttribute("groups", service.findAll().get());
        return "groups";
    }
}
