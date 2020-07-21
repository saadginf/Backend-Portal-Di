package com.di.sd.backapi.modals;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
@MappedSuperclass
public abstract class infoOuvrage {
    
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        @Column(unique=true, updatable = false)
        @NotBlank(message = "Champ obligatoire")
        private String libbele;
    

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
     * @return String return the libbele
     */
    public String getLibbele() {
        return libbele;
    }

    /**
     * @param libbele the libbele to set
     */
    public void setLibbele(String libbele) {
        this.libbele = libbele;
    }

    public infoOuvrage() {
    }

}