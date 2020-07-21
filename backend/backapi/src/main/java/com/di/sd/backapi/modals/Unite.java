package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Unite extends infoOuvrage{
    @OneToMany(mappedBy = "unite")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Exemplaire> exeplaires;
    
    public Unite() {
        super();
    }
    


    /**
     * @return Set<Exemplaire> return the exeplaires
     */
    public Set<Exemplaire> getExeplaires() {
        return exeplaires;
    }

    /**
     * @param exeplaires the exeplaires to set
     */
    public void setExeplaires(Set<Exemplaire> exeplaires) {
        this.exeplaires = exeplaires;
    }

}