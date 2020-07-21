package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Theme extends infoOuvrage {
    @OneToMany(mappedBy = "theme")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Ouvrage> ouvrages;
    public Theme() {
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