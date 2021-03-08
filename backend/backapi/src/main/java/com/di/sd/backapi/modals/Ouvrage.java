package com.di.sd.backapi.modals;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Ouvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Le titre du livre est obligatoire")
    private String titre;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date anneePublication;
    private String descriptif;
    private Integer nbrePret;
    // Orignine
    @ManyToOne
    @JoinColumn(name = "ID_ORIGINE")

    private Origine origine;
    // Theme
    @ManyToOne
    @JoinColumn(name = "ID_THEME")
    private Theme theme;
    // type

    @ManyToOne
    @JoinColumn(name = "ID_TYPE")
    private Type type;

    // clqssification
    @ManyToOne
    @JoinColumn(name = "ID_CLASS")
    private Classification classification;

    // auteur
    @ManyToMany
    @JoinTable(name = "AUT_OU", joinColumns = @JoinColumn(name = "OU_ID"), inverseJoinColumns = @JoinColumn(name = "AUT_ID"))
    private Set<Auteur> auteurs;
    // exemplaire
    @OneToMany(mappedBy = "ouvrage")
    private Set<Tome> tomes;

    // Mots clefs
    @ManyToMany
    @JoinTable(name = "MC_OU", joinColumns = @JoinColumn(name = "MC_ID"), inverseJoinColumns = @JoinColumn(name = "AUT_ID"))
    private Set<MotsClefs> motsClefs;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "ID_EDITEUR")
    private Editeur editeur;
    private String fileLink;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public Ouvrage() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return Date return the anneePublication
     */
    public Date getAnneePublication() {
        return anneePublication;
    }

    /**
     * @param anneePublication the anneePublication to set
     */
    public void setAnneePublication(Date anneePublication) {
        this.anneePublication = anneePublication;
    }

    /**
     * @return Origine return the origine
     */
    public Origine getOrigine() {
        return origine;
    }

    /**
     * @param origine the origine to set
     */
    public void setOrigine(Origine origine) {
        this.origine = origine;
    }

    /**
     * @return Theme return the theme
     */
    public Theme getTheme() {
        return theme;
    }

    /**
     * @param theme the theme to set
     */
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * @return Type return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * @return Classification return the classification
     */
    public Classification getClassification() {
        return classification;
    }

    /**
     * @param classification the classification to set
     */
    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    /**
     * @return Set<Auteur> return the auteurs
     */
    public Set<Auteur> getAuteurs() {
        return auteurs;
    }

    /**
     * @param auteurs the auteurs to set
     */
    public void setAuteurs(Set<Auteur> auteurs) {
        this.auteurs = auteurs;
    }

    /**
     * @return Set<MotsClefs> return the motsClefs
     */
    public Set<MotsClefs> getMotsClefs() {
        return motsClefs;
    }

    /**
     * @param motsClefs the motsClefs to set
     */
    public void setMotsClefs(Set<MotsClefs> motsClefs) {
        this.motsClefs = motsClefs;
    }

    /**
     * @return Set<Tome> return the tomes
     */
    public Set<Tome> getTomes() {
        return tomes;
    }

    /**
     * @param tomes the tomes to set
     */
    public void setTomes(Set<Tome> tomes) {
        this.tomes = tomes;
    }

    /**
     * @return Date return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return Editeur return the editeur
     */
    public Editeur getEditeur() {
        return editeur;
    }

    /**
     * @param editeur the editeur to set
     */
    public void setEditeur(Editeur editeur) {
        this.editeur = editeur;
    }

    /**
     * @return String return the descriptif
     */
    public String getDescriptif() {
        return descriptif;
    }

    /**
     * @param descriptif the descriptif to set
     */
    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    /**
     * @return int return the nbrePret
     */
    public Integer getNbrePret() {
        return nbrePret;
    }

    /**
     * @param nbrePret the nbrePret to set
     */
    public void setNbrePret(Integer nbrePret) {
        this.nbrePret = nbrePret;
    }

    /**
     * @return String return the fileLink
     */
    public String getFileLink() {
        return fileLink;
    }

    /**
     * @param fileLink the fileLink to set
     */
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    @Override
    public String toString() {
        return "Ouvrage [anneePublication=" + anneePublication + ", classification=" + classification + ", createdAt="
                + createdAt + ", descriptif=" + descriptif + ", editeur=" + editeur + ", fileLink=" + fileLink + ", id="
                + id + ", nbrePret=" + nbrePret + ", origine=" + origine + ", theme=" + theme + ", titre=" + titre
                + ", type=" + type + "]";
    }

}