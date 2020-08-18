package com.di.sd.backapi.modals;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Emprunteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Champ obligatoire")
    private String nomPrenom;
    @ManyToOne
    @JoinColumn(name="ID_UNITE")
    private Unite unite;
    private String service;
    @ManyToOne
    @JoinColumn(name="ID_GRADE")
    private Grade grade;

    public Emprunteur() {
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
     * @return String return the nomPrenom
     */
    public String getNomPrenom() {
        return nomPrenom;
    }

    /**
     * @param nomPrenom the nomPrenom to set
     */
    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    /**
     * @return Unite return the unite
     */
    public Unite getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    /**
     * @return String return the service
     */
    public String getService() {
        return service;
    }

    /**
     * @param service the service to set
     */
    public void setService(String service) {
        this.service = service;
    }

    /**
     * @return Grade return the grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

}