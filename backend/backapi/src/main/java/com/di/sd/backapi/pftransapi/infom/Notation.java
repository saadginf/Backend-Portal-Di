package com.di.sd.backapi.pftransapi.infom;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.di.sd.backapi.pftransapi.personnel.Personnel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Notation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long value;
    private Double note;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateNote;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Personnel personel;

    public Notation() {
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
     * @return Double return the note
     */
    public Double getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(Double note) {
        this.note = note;
    }

    /**
     * @return Date return the dateNote
     */
    public Date getDateNote() {
        return dateNote;
    }

    /**
     * @param dateNote the dateNote to set
     */
    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }


    /**
     * @return Personnel return the personel
     */
    public Personnel getPersonel() {
        return personel;
    }

    /**
     * @param personel the personel to set
     */
    public void setPersonel(Personnel personel) {
        this.personel = personel;
    }

}