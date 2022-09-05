package mx.axiomagency.alternativecourses.service;

import mx.axiomagency.alternativecourses.dto.GradeDto;

import java.util.List;

public interface GradesService {

    GradeDto createUpdateGradeService(GradeDto gradeDto);

    Integer deleteGradeService(Integer gradeId);

    List<GradeDto> getGradesByStudent(Integer studentId);

    GradeDto getGradeByIdService(Integer gradeId);


}
