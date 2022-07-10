package ua.foxminded.herasimov.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.foxminded.herasimov.university.dto.TimetableDto;
import ua.foxminded.herasimov.university.dto.TimetableDtoMapper;
import ua.foxminded.herasimov.university.entity.Timetable;
import ua.foxminded.herasimov.university.service.impl.TimetableServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/timetables")
public class TimetableController {

    private TimetableServiceImpl service;
    private TimetableDtoMapper mapper;

    @Autowired
    public TimetableController(TimetableServiceImpl service,
                               TimetableDtoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String showAllTimetables(Model model) {
        List<Timetable> timetables = service.findAll().get();
        List<TimetableDto> dtoList = timetables.stream().map(t -> mapper.toDto(t)).collect(Collectors.toList());
        model.addAttribute("timetables", dtoList);
        return "timetable";
    }

}
