package mx.axiomagency.alternativecourses.model.dao;

import mx.axiomagency.alternativecourses.model.persistence.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectsRepository extends JpaRepository<Subject, Integer> {
}
