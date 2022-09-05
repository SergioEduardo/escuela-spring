package mx.axiomagency.alternativecourses.service.impl;

import mx.axiomagency.alternativecourses.dto.StudentDto;
import mx.axiomagency.alternativecourses.dto.SubjectDto;
import mx.axiomagency.alternativecourses.model.dao.SubjectsRepository;
import mx.axiomagency.alternativecourses.model.persistence.Subject;
import mx.axiomagency.alternativecourses.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    @Autowired
    private SubjectsRepository subjectsRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SubjectDto> getSubjectsService() {
        List<Subject> subjects = subjectsRepository.findAll();
        List<SubjectDto> subjectDtoList = subjects
                .stream()
                .map(subject -> new SubjectDto(
                        subject.getSubjectId(),
                        subject.getName()))
                .collect(Collectors.toList());
        return subjectDtoList;
    }
}
