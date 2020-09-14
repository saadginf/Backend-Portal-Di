package com.di.sd.backapi.pftransapi.grade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GradePerso {
    @Id
    private Long value;
    private String label;
    @ManyToOne
    @JoinColumn(name = "ID_CAT")
    private CateorieGrade catGrade;

    /**
     * @return Long return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    public GradePerso() {
    }


    /**
     * @return CateorieGrade return the catGrade
     */
    public CateorieGrade getCatGrade() {
        return catGrade;
    }

    /**
     * @param catGrade the catGrade to set
     */
    public void setCatGrade(CateorieGrade catGrade) {
        this.catGrade = catGrade;
    }

}