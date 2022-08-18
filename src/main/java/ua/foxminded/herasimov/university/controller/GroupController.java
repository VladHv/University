package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.foxminded.herasimov.university.entity.Group;
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
    public String showGroups(Model model) {
        model.addAttribute("groups", service.findAll());
        model.addAttribute("group", new Group.Builder().build());
        return "groups";
    }

    @PostMapping("/")
    public String createGroup(@ModelAttribute("group") Group group) {
        service.create(group);
        return "redirect:/groups/";
    }

    @GetMapping("/delete/{id}")
    public String deleteGroup(@PathVariable("id") Integer id) {
        service.delete(id);
        return "redirect:/groups/";
    }

    @GetMapping("/{id}")
    public String showGroupById(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("group", service.findById(id));
        return "group_page";
    }

    @PostMapping("/{id}")
    public String updateGroup(@ModelAttribute("group") Group group) {
        service.update(group);
        return "redirect:/groups/{id}";
    }
}
