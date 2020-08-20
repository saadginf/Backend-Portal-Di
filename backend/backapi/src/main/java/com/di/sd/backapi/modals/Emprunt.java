package com.di.sd.backapi.modals;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateDebut;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateRetour;
    @ManyToOne
     @JoinColumn(name="ID_EMPRUNTEUR")
    private Emprunteur emprunteur;
    @ManyToOne
    @JoinColumn(name="ID_EXEMP")
    private Exemplaire exemplaire;





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
     * @return Date return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return Date return the dateRetour
     */
    public Date getDateRetour() {
        return dateRetour;
    }

    /**
     * @param dateRetour the dateRetour to set
     */
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

 

    /**
     * @return Exemplaire return the exemplaire
     */
    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    /**
     * @param exemplaire the exemplaire to set
     */
    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public Emprunt() {
    }

    public Emprunteur getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(Emprunteur emprunteur) {
        this.emprunteur = emprunteur;
    }

}