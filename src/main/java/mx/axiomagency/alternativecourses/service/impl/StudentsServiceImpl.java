package mx.axiomagency.alternativecourses.service.impl;

import mx.axiomagency.alternativecourses.dto.StudentDto;
import mx.axiomagency.alternativecourses.model.dao.StudentsRepository;
import mx.axiomagency.alternativecourses.model.persistence.Student;
import mx.axiomagency.alternativecourses.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> getStudentsService() {
        List<Student> students = studentsRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(
                        student.getStudentId(),
                        student.getName(),
                        student.getLastName(),
                        student.getmLastName()))
                .collect(Collectors.toList());
        return studentDtoList;
    }
}
