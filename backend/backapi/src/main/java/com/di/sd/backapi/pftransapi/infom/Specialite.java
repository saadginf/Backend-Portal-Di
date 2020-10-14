package com.di.sd.backapi.pftransapi.infom;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Specialite {
    @Id
    private Long value;
    private String label;

    public Specialite() {
        //controller
    }

    

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

}