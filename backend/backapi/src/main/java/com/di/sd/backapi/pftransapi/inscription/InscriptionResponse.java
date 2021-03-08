package com.di.sd.backapi.pftransapi.inscription;

public class InscriptionResponse {
    private Long idpers;
    private String grade;
    private String nom;
    private String prenom;
    private String unite;
    private String mle;
    private String statut;
    private String motif;

    /**
     * @return String return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return String return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return String return the mle
     */
    public String getMle() {
        return mle;
    }

    /**
     * @param mle the mle to set
     */
    public void setMle(String mle) {
        this.mle = mle;
    }

    /**
     * @return String return the statut
     */
    public String getStatut() {
        return statut;
    }

    /**
     * @param statut the statut to set
     */
    public void setStatut(String statut) {
        this.statut = statut;
    }

    /**
     * @return String return the motif
     */
    public String getMotif() {
        return motif;
    }

    /**
     * @param motif the motif to set
     */
    public void setMotif(String motif) {
        this.motif = motif;
    }

    public InscriptionResponse() {
    }

    /**
     * @return String return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return String return the unite
     */
    public String getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * @return Long return the idpers
     */
    public Long getIdpers() {
        return idpers;
    }

    /**
     * @param idpers the idpers to set
     */
    public void setIdpers(Long idpers) {
        this.idpers = idpers;
    }

}
