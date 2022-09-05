package mx.axiomagency.alternativecourses.controller;

import mx.axiomagency.alternativecourses.dto.StudentDto;
import mx.axiomagency.alternativecourses.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/students")
    private List<StudentDto> getStudentsController(){
        return  studentsService.getStudentsService();

    }

}
