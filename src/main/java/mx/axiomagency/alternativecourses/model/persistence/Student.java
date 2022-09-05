package mx.axiomagency.alternativecourses.model.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_alumnos")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_usuarios")
    private Integer studentId;
    @Column(name = "nombre", length = 80)
    private String name;
    @Column(name = "ap_paterno", length = 80)
    private String lastName;
    @Column(name = "ap_materno", length = 80)
    private String mLastName;
    @Column(name = "activo")
    private Boolean isEnable;

    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private Set<Grade> grades = new LinkedHashSet<>();

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Integer getStudentId() {
        return studentId;
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

    public Boolean getEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(studentId, student.studentId) && Objects.equals(name, student.name) && Objects.equals(lastName, student.lastName) && Objects.equals(mLastName, student.mLastName) && Objects.equals(isEnable, student.isEnable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, name, lastName, mLastName, isEnable);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
