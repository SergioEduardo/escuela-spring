package mx.axiomagency.alternativecourses.service.impl;

import mx.axiomagency.alternativecourses.dto.GradeDto;
import mx.axiomagency.alternativecourses.model.dao.GradesRepository;
import mx.axiomagency.alternativecourses.model.dao.StudentsRepository;
import mx.axiomagency.alternativecourses.model.dao.SubjectsRepository;
import mx.axiomagency.alternativecourses.model.persistence.Grade;
import mx.axiomagency.alternativecourses.model.persistence.Student;
import mx.axiomagency.alternativecourses.model.persistence.Subject;
import mx.axiomagency.alternativecourses.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradesServiceImpl implements GradesService {

    @Autowired
    private GradesRepository gradesRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    @Transactional
    public GradeDto createUpdateGradeService(GradeDto gradeDto) {
        Student student = studentsRepository.findById(gradeDto.getStudentId()).orElse(null);
        Subject subject = subjectsRepository.findById(gradeDto.getSubjectId()).orElse(null);
        LocalDate localDate = LocalDate.now();
        Grade grade = new Grade();
        if (gradeDto.getGradeId() != null) {
            grade.setGradeId(gradeDto.getGradeId());
        }
        grade.setGrade(gradeDto.getGrade());
        grade.setStudent(student);
        grade.setSubject(subject);
        grade.setRegistrationDate(localDate);
        gradesRepository.save(grade);
        gradeDto.setGradeId(grade.getGradeId());
        return gradeDto;
    }

    @Override
    public Integer deleteGradeService(Integer gradeId) {
        Grade grade = gradesRepository.findById(gradeId).orElse(null);
        gradesRepository.delete(grade);
        return gradeId;
    }

    @Override
    @Transactional(readOnly = true)
    public List<GradeDto> getGradesByStudent(Integer studentId) {
        List<Grade> grades = gradesRepository.findAllByStudentStudentId(studentId);
        List<GradeDto> gradeDtoList = grades
                .stream()
                .map(grade -> new GradeDto(
                        grade.getGradeId(),
                        grade.getSubject().getName(),
                        grade.getGrade(), grade.getRegistrationDate()))
                .collect(Collectors.toList());
        return gradeDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public GradeDto getGradeByIdService(Integer gradeId) {
        Grade grade = gradesRepository.findById(gradeId).orElse(null);
        GradeDto gradeDto = new GradeDto();
        gradeDto.setGradeId(gradeId);
        gradeDto.setStudentId(grade.getStudent().getStudentId());
        gradeDto.setSubjectId(grade.getSubject().getSubjectId());
        gradeDto.setGrade(grade.getGrade());
        return gradeDto;
    }
}
