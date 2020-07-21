package com.di.sd.backapi.utils;

import java.util.ArrayList;
import java.util.List;


public class AllFields {
    private List<Fiels> origine = new ArrayList<Fiels>() ;
    private List<Fiels> theme= new ArrayList<Fiels>();
    private List<Fiels> type= new ArrayList<Fiels>();
    private List<Fiels> classification= new ArrayList<Fiels>();
    private List<Fiels> auteurs= new ArrayList<Fiels>();
    private List<Fiels> editeur= new ArrayList<Fiels>();
    private List<Fiels> ouvrages= new ArrayList<Fiels>();
    private List<Fiels> formats = new ArrayList<Fiels>();
    private List<Fiels> unites = new ArrayList<Fiels>();
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
     * @return List<Fiels> return the theme
     */
    public List<Fiels> getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(List<Fiels> theme) {
        this.theme = theme;
    }

    /**
     * @return List<Fiels> return the type
     */
    public List<Fiels> getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(List<Fiels> type) {
        this.type = type;
    }

    /**
     * @return List<Fiels> return the classification
     */
    public List<Fiels> getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(List<Fiels> classification) {
        this.classification = classification;
    }

    /**
     * @return List<Fiels> return the auteurs
     */
    public List<Fiels> getAuteurs() {
        return auteurs;
    }

    /**
     * @param auteurs the auteurs to set
     */
    public void setAuteurs(List<Fiels> auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * @return List<Fiels> return the editeur
     */
    public List<Fiels> getEditeur() {
        return editeur;
    }

    /**
     * @param editeur the editeur to set
     */
    public void setEditeur(List<Fiels> editeur) {
        this.editeur = editeur;
    }

    /**
     * @return List<Ouvrages> return the ouvrages
     */
    public List<Fiels> getOuvrages() {
        return ouvrages;
    }

    /**
     * @param ouvrages the ouvrages to set
     */
    public void setOuvrages(List<Fiels> ouvrages) {
        this.ouvrages = ouvrages;
    }

    public AllFields() {
    }

    public List<Fiels> getFormats() {
        return formats;
    }

    public void setFormats(List<Fiels> formats) {
        this.formats = formats;
    }

    public List<Fiels> getUnites() {
        return unites;
    }

    public void setUnites(List<Fiels> unites) {
        this.unites = unites;
    }

}