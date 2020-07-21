package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Tome extends infoOuvrage {

    @ManyToOne
    @JoinColumn(name="ID_OU")
  
    private Ouvrage ouvrage;
    @OneToMany(mappedBy = "tome")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Exemplaire> exemplaires;

    public Tome() {
        super();
    }


        





    /**
     * @return Ouvrage return the ouvrage
     */
    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    /**
     * @param ouvrage the ouvrage to set
     */
    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    /**
     * @return Set<Exemplaire> return the exemplaires
     */
    public Set<Exemplaire> getExemplaires() {
        return exemplaires;
    }

    /**
     * @param exemplaires the exemplaires to set
     */
    public void setExemplaires(Set<Exemplaire> exemplaires) {
        this.exemplaires = exemplaires;
    }

}
