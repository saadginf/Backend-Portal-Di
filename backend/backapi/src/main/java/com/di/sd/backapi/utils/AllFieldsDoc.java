package com.di.sd.backapi.utils;

import java.util.ArrayList;
import java.util.List;

import com.di.sd.backapi.modals.ThemeDoc;
import com.di.sd.backapi.modals.TypeDoc;


public class AllFieldsDoc {
    private Iterable<ThemeDoc> themes = new ArrayList<ThemeDoc>() ;
    private List<Fiels> origine= new ArrayList<Fiels>();
    private Iterable<TypeDoc> type= new ArrayList<TypeDoc>();
    private List<Fiels> classification= new ArrayList<Fiels>();
    private List<Fiels> documents= new ArrayList<Fiels>();
    private List<Fiels> unites = new ArrayList<Fiels>();

    public AllFieldsDoc() {
    }

    public Iterable<ThemeDoc> getThemes() {
        return themes;
    }

    public void setThemes(Iterable<ThemeDoc> themes2) {
        this.themes = themes2;
    }

    public List<Fiels> getOrigine() {
        return origine;
    }

    public void setOrigine(List<Fiels> origine) {
        this.origine = origine;
    }

    public Iterable<TypeDoc> getType() {
        return type;
    }

    public void setType(Iterable<TypeDoc> type) {
        this.type = type;
    }

    public List<Fiels> getClassification() {
        return classification;
    }

    public void setClassification(List<Fiels> classification) {
        this.classification = classification;
    }

    public List<Fiels> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Fiels> documents) {
        this.documents = documents;
    }

    public List<Fiels> getUnites() {
        return unites;
    }

    public void setUnites(List<Fiels> unites) {
        this.unites = unites;
    }
   

}