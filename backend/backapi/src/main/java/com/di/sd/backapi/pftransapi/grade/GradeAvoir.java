package com.di.sd.backapi.pftransapi.grade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.di.sd.backapi.pftransapi.personnel.Personnel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class GradeAvoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Personnel personel;
    @ManyToOne
    @JoinColumn(name="ID_GRADE")
    private GradePerso grade;
    private Date dateGrade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


   
 

    public GradeAvoir() {
    }



    /**
     * @return Grade return the grade
     */
    public GradePerso getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(GradePerso grade) {
        this.grade = grade;
    }

    /**
     * @return Date return the dateGrade
     */
    public Date getDateGrade() {
        return dateGrade;
    }

    /**
     * @param dateGrade the dateGrade to set
     */
    public void setDateGrade(Date dateGrade) {
        this.dateGrade = dateGrade;
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