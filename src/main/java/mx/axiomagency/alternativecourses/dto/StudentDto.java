package mx.axiomagency.alternativecourses.dto;

import mx.axiomagency.alternativecourses.model.persistence.Student;

import java.io.Serializable;

public class StudentDto implements Serializable {

    private Integer studentId;
    private String name;
    private String lastName;
    private String mLastName;

    public Integer getStudentId() {
        return studentId;
    }

    public StudentDto() {
    }

    public StudentDto(Integer studentId, String name, String lastName, String mLastName) {
        this.studentId = studentId;
        this.name = name;
        this.lastName = lastName;
        this.mLastName = mLastName;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                '}';
    }
}
