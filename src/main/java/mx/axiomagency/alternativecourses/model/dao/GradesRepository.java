package mx.axiomagency.alternativecourses.model.dao;

import mx.axiomagency.alternativecourses.model.persistence.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradesRepository extends JpaRepository<Grade, Integer> {

    List<Grade> findAllByStudentStudentId(Integer studentId);


}
