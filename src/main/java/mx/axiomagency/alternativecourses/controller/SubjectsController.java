package mx.axiomagency.alternativecourses.controller;

import mx.axiomagency.alternativecourses.dto.SubjectDto;
import mx.axiomagency.alternativecourses.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubjectsController {

    @Autowired
    private SubjectsService subjectsService;

    @GetMapping("/subjects")
    private List<SubjectDto> getSubjectsController(){
        return subjectsService.getSubjectsService();

    }

}
