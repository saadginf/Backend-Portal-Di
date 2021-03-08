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
public class Penalisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long value;
    private Long nbrJour;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date datePenalisation;
    private String motif;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Personnel personel;
    public Penalisation() {
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
     * @return Long return the nbrJour
     */
    public Long getNbrJour() {
        return nbrJour;
    }

    /**
     * @param nbrJour the nbrJour to set
     */
    public void setNbrJour(Long nbrJour) {
        this.nbrJour = nbrJour;
    }

    /**
     * @return Date return the datePenalisation
     */
    public Date getDatePenalisation() {
        return datePenalisation;
    }

    /**
     * @param datePenalisation the datePenalisation to set
     */
    public void setDatePenalisation(Date datePenalisation) {
        this.datePenalisation = datePenalisation;
    }

    /**
     * @return String return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * @param motif the motif to set
     */
    public void setMotif(String motif) {
        this.motif = motif;
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