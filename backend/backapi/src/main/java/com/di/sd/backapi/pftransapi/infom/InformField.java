package com.di.sd.backapi.pftransapi.infom;

import java.util.ArrayList;
import java.util.List;

import com.di.sd.backapi.utils.Fiels;

public class InformField {
    private List<Fiels> echelleSolde = new ArrayList<Fiels>();
    private List<Fiels> foctions = new ArrayList<Fiels>();
    private List<Fiels> niveauIns = new ArrayList<Fiels>();
    private List<Fiels> origine = new ArrayList<Fiels>();
    private List<Fiels> speialite = new ArrayList<Fiels>();
    private List<Fiels> grade = new ArrayList<Fiels>();
    private List<Fiels> position = new ArrayList<Fiels>();
    private List<Fiels> unite = new ArrayList<Fiels>();

    /**
     * @return List<Fiels> return the echelleSolde
     */
    public List<Fiels> getEchelleSolde() {
        return echelleSolde;
    }

    /**
     * @param echelleSolde the echelleSolde to set
     */
    public void setEchelleSolde(List<Fiels> echelleSolde) {
        this.echelleSolde = echelleSolde;
    }

    /**
     * @return List<Fiels> return the foctions
     */
    public List<Fiels> getFoctions() {
        return foctions;
    }

    /**
     * @param foctions the foctions to set
     */
    public void setFoctions(List<Fiels> foctions) {
        this.foctions = foctions;
    }

    /**
     * @return List<Fiels> return the niveauIns
     */
    public List<Fiels> getNiveauIns() {
        return niveauIns;
    }

    /**
     * @param niveauIns the niveauIns to set
     */
    public void setNiveauIns(List<Fiels> niveauIns) {
        this.niveauIns = niveauIns;
    }

    /**
     * @return List<Fiels> return the origine
     */
    public List<Fiels> getOrigine() {
        return origine;
    }

    /**
     * @param origine the origine to set
     */
    public void setOrigine(List<Fiels> origine) {
        this.origine = origine;
    }

    /**
     * @return List<Fiels> return the speialite
     */
    public List<Fiels> getSpeialite() {
        return speialite;
    }

    /**
     * @param speialite the speialite to set
     */
    public void setSpeialite(List<Fiels> speialite) {
        this.speialite = speialite;
    }

    /**
     * @return List<Fiels> return the grade
     */
    public List<Fiels> getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(List<Fiels> grade) {
        this.grade = grade;
    }

    public InformField() {
    }

    /**
     * @return List<Fiels> return the position
     */
    public List<Fiels> getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(List<Fiels> position) {
        this.position = position;
    }

    /**
     * @return List<Fiels> return the unite
     */
    public List<Fiels> getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(List<Fiels> unite) {
        this.unite = unite;
    }

}