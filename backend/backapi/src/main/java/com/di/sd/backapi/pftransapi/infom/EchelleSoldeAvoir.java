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
public class EchelleSoldeAvoir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="ID_PERSONEL")
    private Personnel personel;
    @ManyToOne
    @JoinColumn(name="ID_ECHELLE")
    private EchelleSolde echelleSolde;
    private Date dateEchelle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Personnel getPersonel() {
        return personel;
    }

    public void setPersonel(Personnel personnel) {
        this.personel = personnel;
    }

    public EchelleSolde getEchelleSolde() {
        return echelleSolde;
    }

    public void setEchelleSolde(EchelleSolde echelleSolde) {
        this.echelleSolde = echelleSolde;
    }

    public Date getDateEchelle() {
        return dateEchelle;
    }

    public void setDateEchelle(Date dateEchelle) {
        this.dateEchelle = dateEchelle;
    }

    public EchelleSoldeAvoir() {
    }


}