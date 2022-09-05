package mx.axiomagency.alternativecourses.model.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "t_calificaciones")
public class Grade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private Integer gradeId;
    @Column(name = "calificacion")
    private Double grade;
    @Column(name = "fecha_registro")
    private LocalDate registrationDate;

    @ManyToOne
    @JoinColumn(name = "id_t_usuarios")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_t_materias")
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade1 = (Grade) o;
        return Objects.equals(gradeId, grade1.gradeId) && Objects.equals(grade, grade1.grade) && Objects.equals(registrationDate, grade1.registrationDate) && Objects.equals(student, grade1.student) && Objects.equals(subject, grade1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, grade, registrationDate, student, subject);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", grade=" + grade +
                ", registrationDate=" + registrationDate +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }
}
