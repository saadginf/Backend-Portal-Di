package com.di.sd.backapi.pftransapi.infom;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.di.sd.backapi.pftransapi.personnel.Personnel;
@Entity
public class FonctionAvoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    private Personnel personel;
    @ManyToOne
    @JoinColumn(name="ID_FONCTION")
    private Fonction fonction;
    private Date dateDebutAff;
    private Date dateFinAff;

    public FonctionAvoir() {
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
     * @return Fonction return the fonction
     */
    public Fonction getFonction() {
        return fonction;
    }

    /**
     * @param fonction the fonction to set
     */
    public void setFonction(Fonction fonction) {
        this.fonction = fonction;
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

}