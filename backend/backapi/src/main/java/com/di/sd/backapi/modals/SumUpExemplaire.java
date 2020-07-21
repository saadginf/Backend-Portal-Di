package com.di.sd.backapi.modals;


public class SumUpExemplaire {
    private String rayonId;
    private String unite;
    private String titre;
    private String auteurs;
    private String classification;
    private String theme;
    private int position;

    /**
     * @return String return the rayonId
     */
    public String getRayonId() {
        return rayonId;
    }

    /**
     * @param rayonId the rayonId to set
     */
    public void setRayonId(String rayonId) {
        this.rayonId = rayonId;
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
     * @return String return the classification
     */
    public String getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * @return int return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    public SumUpExemplaire(String rayonId, String titre, String auteurs, String classification, int position) {
        this.rayonId = rayonId;
        this.titre = titre;
        this.auteurs = auteurs;
        this.classification = classification;
        this.position = position;
    }

	public SumUpExemplaire() {
	}


    /**
     * @return String return the theme
     */
    public String getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(String theme) {
        this.theme = theme;
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

}