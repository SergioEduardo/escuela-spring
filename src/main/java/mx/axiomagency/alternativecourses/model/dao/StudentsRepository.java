package mx.axiomagency.alternativecourses.model.dao;

import mx.axiomagency.alternativecourses.model.persistence.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
}
