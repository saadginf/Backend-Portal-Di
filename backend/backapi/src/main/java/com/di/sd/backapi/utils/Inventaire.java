package com.di.sd.backapi.utils;

import java.util.List;

public class Inventaire {
    private String number;
    private String date_ac;
    private String titre;
    private String auteurs;
    private String editeur;
    private int date_pub;
    private List<String> tomes;
    private List<Integer> qte;

    public Inventaire() {
    }
    
    




    /**
     * @return String return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * @return String return the date_ac
     */
    public String getDate_ac() {
        return date_ac;
    }

    /**
     * @param date_ac the date_ac to set
     */
    public void setDate_ac(String date_ac) {
        this.date_ac = date_ac;
    }

    /**
     * @return String return the titre
     */
    public String getTitre() {
        return titre;
    }

    /**
     * @param titre the titre to set
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * @return String return the auteurs
     */
    public String getAuteurs() {
        return auteurs;
    }

    /**
     * @param auteurs the auteurs to set
     */
    public void setAuteurs(String auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * @return String return the editeur
     */
    public String getEditeur() {
        return editeur;
    }

    /**
     * @param editeur the editeur to set
     */
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    /**
     * @return int return the date_pub
     */
    public int getDate_pub() {
        return date_pub;
    }

    /**
     * @param date_pub the date_pub to set
     */
    public void setDate_pub(int date_pub) {
        this.date_pub = date_pub;
    }

    /**
     * @return List<String> return the tomes
     */
    public List<String> getTomes() {
        return tomes;
    }

    /**
     * @param tomes the tomes to set
     */
    public void setTomes(List<String> tomes) {
        this.tomes = tomes;
    }

    /**
     * @return List<Integer> return the qte
     */
    public List<Integer> getQte() {
        return qte;
    }

    /**
     * @param qte the qte to set
     */
    public void setQte(List<Integer> qte) {
        this.qte = qte;
    }

}