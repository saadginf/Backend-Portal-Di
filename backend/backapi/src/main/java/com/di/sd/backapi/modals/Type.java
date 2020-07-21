package com.di.sd.backapi.modals;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
public class Type extends infoOuvrage {
    @OneToMany(mappedBy = "type")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Ouvrage> ouvrages;
    public Type() {
        super();
    }
    
}