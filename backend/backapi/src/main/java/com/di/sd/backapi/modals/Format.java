package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Format extends infoOuvrage{
    @OneToMany(mappedBy = "format")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Exemplaire> exemplaires;
    public Format() {
        super();
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