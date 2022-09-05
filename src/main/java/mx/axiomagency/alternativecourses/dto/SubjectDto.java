package mx.axiomagency.alternativecourses.dto;

import java.io.Serializable;

public class SubjectDto implements Serializable {

    private Integer subjectId;
    private String name;

    public SubjectDto() {
    }

    public SubjectDto(Integer subjectId, String name) {
        this.subjectId = subjectId;
        this.name = name;
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

    @Override
    public String toString() {
        return "SubjectDto{" +
                "subjectId=" + subjectId +
                ", name='" + name + '\'' +
                '}';
    }
}
