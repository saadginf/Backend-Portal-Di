package com.di.sd.backapi.modals;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rayonId;
    @NotBlank(message = "l'Etat de l'exemplaire est obligatoire")
    private String etat;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dateAcquisition;
    @NotBlank(message = "Reference Obligatoire")
    private String reference;
    private boolean existe =true;
    @ManyToOne
    @JoinColumn(name="ID_FORMAT")
    private Format format;
    @ManyToOne
    @JoinColumn(name="ID_UNITE")
    private Unite unite;
    

    @ManyToOne
    @JoinColumn(name="ID_TOME")
    
    private Tome tome;
    public Exemplaire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    /**
     * @return String return the rayonId
     */
    public String getRayonId() {
        return rayonId;
    }

    /**
     * @param rayonId the rayonId to set
     */
    public void setRayonId(String rayonId) {
        this.rayonId = rayonId;
    }

   
    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }


 

    /**
     * @return Tome return the tome
     */
    public Tome getTome() {
        return tome;
    }

    /**
     * @param tome the tome to set
     */
    public void setTome(Tome tome) {
        this.tome = tome;
    }

    public boolean isExiste() {
        return existe;
    }

    public void setExiste(boolean existe) {
        this.existe = existe;
    }




}