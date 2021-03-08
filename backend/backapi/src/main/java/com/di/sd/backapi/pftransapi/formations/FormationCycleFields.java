package com.di.sd.backapi.pftransapi.formations;

import java.util.ArrayList;
import java.util.List;

import com.di.sd.backapi.utils.Fiels;

public class FormationCycleFields {
    private List<Fiels> formations = new ArrayList<Fiels>();
    private List<Fiels> cycleScolaire = new ArrayList<Fiels>();

    /**
     * @return List<Fiels> return the formations
     */
    public List<Fiels> getFormations() {
        return formations;
    }

    /**
     * @param formations the formations to set
     */
    public void setFormations(List<Fiels> formations) {
        this.formations = formations;
    }

    /**
     * @return List<Fiels> return the cycleScolaire
     */
    public List<Fiels> getCycleScolaire() {
        return cycleScolaire;
    }

    /**
     * @param cycleScolaire the cycleScolaire to set
     */
    public void setCycleScolaire(List<Fiels> cycleScolaire) {
        this.cycleScolaire = cycleScolaire;
    }

}