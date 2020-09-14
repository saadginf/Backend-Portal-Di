package com.di.sd.backapi.pftransapi.unites;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UniteAffectation {
    @Id
    private Long value;
    private String label;
    @ManyToOne
    @JoinColumn(name="ID_INSPECTION")
    private Inspection inspection;

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

    public Inspection getInspection() {
        return inspection;
    }

    public void setInspection(Inspection inspection) {
        this.inspection = inspection;
    }

    public UniteAffectation() {
    }

    
}