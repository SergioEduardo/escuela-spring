package mx.axiomagency.alternativecourses.controller;

import mx.axiomagency.alternativecourses.dto.AverageDto;
import mx.axiomagency.alternativecourses.dto.GradeDto;
import mx.axiomagency.alternativecourses.dto.Response;
import mx.axiomagency.alternativecourses.dto.ResponseGrades;
import mx.axiomagency.alternativecourses.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/grades")
public class GradesController {

    private final String OK_MESSAGE = "ok";
    private final String MESSAGE_CREATE = "calificacion registrada";
    private final String MESSAGE_UPDATE = "calificacion actualizada";
    private final String MESSAGE_DELETE = "calificacion eliminada";


    @Autowired
    private GradesService gradesService;

    @PostMapping("/create")
    private Response createGradeController(@RequestBody GradeDto gradeDto){
        gradeDto = gradesService.createUpdateGradeService(gradeDto);
        Response response = null;
        if(gradeDto.getGradeId() != null){
            response = new Response();
            response.setSuccess(OK_MESSAGE);
            response.setMsg(MESSAGE_CREATE);
        }
        return response;
    }

    @GetMapping("/getByStudent/{studentId}")
    private ResponseGrades getGradeByStudentController(@PathVariable("studentId") Integer studentId){
        ResponseGrades response = new ResponseGrades();
        List<GradeDto> gradeDtoList = gradesService.getGradesByStudent(studentId);
        Double avg = gradeDtoList.stream().collect(Collectors.averagingDouble(GradeDto::getGrade));
        AverageDto averageDto = new AverageDto(avg);
        response.setGrades(gradeDtoList);
        response.setAverage(averageDto);
        return response;
    }

    @PutMapping("/update")
    private Response updateGradeController(@RequestBody GradeDto gradeDto){
        Response response = null;
        GradeDto currentGrade = gradesService.getGradeByIdService(gradeDto.getGradeId());
        currentGrade.setGrade(gradeDto.getGrade());
        currentGrade = gradesService.createUpdateGradeService(currentGrade);
        if (currentGrade.getGradeId() != null){
            response = new Response();
            response.setSuccess(OK_MESSAGE);
            response.setMsg(MESSAGE_UPDATE);
        }
        return response;

    }

    @DeleteMapping("/remove")
    private Response deleteGradeController(@RequestBody GradeDto gradeDto){
        gradesService.deleteGradeService(gradeDto.getGradeId());
        Response response = new Response();
        response.setSuccess(OK_MESSAGE);
        response.setMsg(MESSAGE_DELETE);
        return response;
    }

}
