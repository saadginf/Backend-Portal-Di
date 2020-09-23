package com.di.sd.backapi.pftransapi.unites;

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
public class UniteAffAvoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Personnel personel;
    @ManyToOne
    @JoinColumn(name="ID_UNITE")
    private UniteAffectation unite;
    private Date dateDebutAff;
    private Date dateFinAff;

    public UniteAffAvoir() {
    }

    


    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

  

    /**
     * @return UniteAffectation return the unite
     */
    public UniteAffectation getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(UniteAffectation unite) {
        this.unite = unite;
    }

    /**
     * @return Date return the dateDebutAff
     */
    public Date getDateDebutAff() {
        return dateDebutAff;
    }

    /**
     * @param dateDebutAff the dateDebutAff to set
     */
    public void setDateDebutAff(Date dateDebutAff) {
        this.dateDebutAff = dateDebutAff;
    }

    /**
     * @return Date return the dateFinAff
     */
    public Date getDateFinAff() {
        return dateFinAff;
    }

    /**
     * @param dateFinAff the dateFinAff to set
     */
    public void setDateFinAff(Date dateFinAff) {
        this.dateFinAff = dateFinAff;
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