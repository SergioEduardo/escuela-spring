package mx.axiomagency.alternativecourses.model.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_materias")
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_materias")
    private Integer subjectId;
    @Column(name = "nombre", length = 80)
    private String name;
    @Column(name = "activo")
    private Boolean isEnable;

    @OneToMany(mappedBy = "subject", orphanRemoval = true)
    private Set<Grade> grades = new LinkedHashSet<>();

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Subject subject = (Subject) o;
        return Objects.equals(subjectId, subject.subjectId) && Objects.equals(name, subject.name) && Objects.equals(isEnable, subject.isEnable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, name, isEnable);
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                ", isEnable=" + isEnable +
                '}';
    }
}
