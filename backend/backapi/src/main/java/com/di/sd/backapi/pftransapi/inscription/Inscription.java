package com.di.sd.backapi.pftransapi.inscription;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.di.sd.backapi.pftransapi.formations.SessionFormation;
import com.di.sd.backapi.pftransapi.personnel.Personnel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ID_PERS")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Personnel personne;
    private String motif;
    @ManyToOne
    @JoinColumn(name = "ID_SESSION")
    private SessionFormation sformation;
    @ManyToOne
    @JoinColumn(name = "ID_STATUT")
    private Statutinscription statut;

    /**
     * @return Personnel return the personne
     */
    public Personnel getPersonne() {
        return personne;
    }

    /**
     * @param personne the personne to set
     */
    public void setPersonne(Personnel personne) {
        this.personne = personne;
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
     * @return Statutinscription return the statut
     */
    public Statutinscription getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(Statutinscription statut) {
        this.statut = statut;
    }

    public Inscription() {
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
     * @return SessionFormation return the sformation
     */
    public SessionFormation getSformation() {
        return sformation;
    }

    /**
     * @param sformation the sformation to set
     */
    public void setSformation(SessionFormation sformation) {
        this.sformation = sformation;
    }

}