package com.di.sd.backapi.pftransapi.grade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CateorieGrade {
    @Id
    private Long value;
    private String label;

    public CateorieGrade() {
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    
}