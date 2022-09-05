package mx.axiomagency.alternativecourses.dto;

import java.io.Serializable;

public class AverageDto implements Serializable {

    private Double studentAverage;

    public AverageDto() {
    }

    public AverageDto(Double studentAverage) {
        this.studentAverage = studentAverage;
    }

    public Double getStudentAverage() {
        return studentAverage;
    }

    public void setStudentAverage(Double studentAverage) {
        this.studentAverage = studentAverage;
    }
}
