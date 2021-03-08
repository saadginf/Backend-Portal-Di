package com.di.sd.backapi.pftransapi.planification;

import com.di.sd.backapi.pftransapi.inscription.Inscription;

public class PlanficationReponse {
    private Inscription inscription;
    private String personnel;

    /**
     * @return Inscription return the inscription
     */
    public Inscription getInscription() {
        return inscription;
    }

    /**
     * @param inscription the inscription to set
     */
    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    /**
     * @return String return the personnel
     */
    public String getPersonnel() {
        return personnel;
    }

    /**
     * @param personnel the personnel to set
     */
    public void setPersonnel(String personnel) {
        this.personnel = personnel;
    }

    public PlanficationReponse() {
    }

}