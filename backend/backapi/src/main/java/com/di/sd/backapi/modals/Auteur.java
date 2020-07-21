package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Auteur extends infoOuvrage{

    @ManyToMany(mappedBy = "auteurs")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Ouvrage> ouvrages;
    public Auteur() {
        super();
    }
    
    


    /**
     * @return Set<Ouvrage> return the ouvrages
     */
    public Set<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    /**
     * @param ouvrages the ouvrages to set
     */
    public void setOuvrages(Set<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }

}
