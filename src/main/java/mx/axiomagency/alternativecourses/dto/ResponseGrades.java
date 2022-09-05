package mx.axiomagency.alternativecourses.dto;

import java.io.Serializable;
import java.util.List;

public class ResponseGrades implements Serializable {

    List<GradeDto> grades;
    AverageDto average;

    public ResponseGrades() {
    }

    public ResponseGrades(List<GradeDto> grades, AverageDto average) {
        this.grades = grades;
        this.average = average;
    }

    public List<GradeDto> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDto> grades) {
        this.grades = grades;
    }

    public AverageDto getAverage() {
        return average;
    }

    public void setAverage(AverageDto average) {
        this.average = average;
    }
}
