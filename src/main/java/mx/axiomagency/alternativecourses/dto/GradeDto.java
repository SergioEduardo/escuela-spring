package mx.axiomagency.alternativecourses.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GradeDto implements Serializable {

    private Integer gradeId;
    private Integer studentId;
    private String subjectName;
    private Integer subjectId;
    private Double grade;
    private String registrationDate;


    public GradeDto() {
    }

    public GradeDto(Integer gradeId, String subjectName, Double grade, LocalDate registrationDate) {
        this.gradeId = gradeId;
        this.subjectName = subjectName;
        this.grade = grade;
        this.registrationDate = registrationDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "GradeDto{" +
                "gradeId=" + gradeId +
                ", studentId=" + studentId +
                ", subjectName='" + subjectName + '\'' +
                ", subjectId=" + subjectId +
                ", grade=" + grade +
                ", registrationDate='" + registrationDate + '\'' +
                '}';
    }
}
