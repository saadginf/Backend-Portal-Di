package com.di.sd.backapi.modals;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.web.multipart.MultipartFile;



@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "L'objet est obligatoire")
    private String objet;
    @NotBlank(message = "Le rayon Id est obligatoire")
    private String rayonId;
    @NotBlank(message = "Le numéro est obligatoire")
    private String mumero;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateArrivee;
    private String fileDoc;
    @ManyToMany
    @JoinTable(
        name = "REF_DOC", 
    joinColumns = @JoinColumn(name = "DOC_ID"), 
    inverseJoinColumns = @JoinColumn(name = "REF_ID"))
    private List<Document> references;
    @ManyToOne
    @JoinColumn(name="ID_CLASSIFICATION")
    private Classification classification;
    @ManyToOne
    @JoinColumn(name="ID_ORIGINE")
    private Origine origine;
    @ManyToOne
    @JoinColumn(name="ID_TYPE")
    private TypeDoc typedocument;
    @ManyToOne
    @JoinColumn(name="ID_SOUSTHEME")
    private SousTheme sousTheme;

    @Transient
    private MultipartFile file;

    public Document() {
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
     * @return String return the objet
     */
    public String getObjet() {
        return objet;
    }

    /**
     * @param objet the objet to set
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

    /**
     * @return String return the mumero
     */
    public String getMumero() {
        return mumero;
    }

    /**
     * @param mumero the mumero to set
     */
    public void setMumero(String mumero) {
        this.mumero = mumero;
    }

    /**
     * @return Date return the dateArrivee
     */
    public Date getDateArrivee() {
        return dateArrivee;
    }

    /**
     * @param dateArrivee the dateArrivee to set
     */
    public void setDateArrivee(Date dateArrivee) {
        this.dateArrivee = dateArrivee;
    }

    /**
     * @return String return the file
     */
    public String getFileDoc() {
        return fileDoc;
    }

    /**
     * @param file the file to set
     */
    public void setFileDoc(String file) {
        this.fileDoc = file;
    }

    /**
     * @return List<Document> return the references
     */
    public List<Document> getReferences() {
        return references;
    }

    /**
     * @param references the references to set
     */
    public void setReferences(List<Document> references) {
        this.references = references;
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
     * @return TypeDoc return the typedocument
     */
    public TypeDoc getTypedocument() {
        return typedocument;
    }

    /**
     * @param typedocument the typedocument to set
     */
    public void setTypedocument(TypeDoc typedocument) {
        this.typedocument = typedocument;
    }

    /**
     * @return SousTheme return the sousTheme
     */
    public SousTheme getSousTheme() {
        return sousTheme;
    }

    /**
     * @param sousTheme the sousTheme to set
     */
    public void setSousTheme(SousTheme sousTheme) {
        this.sousTheme = sousTheme;
    }


    /**
     * @return MultipartFile return the docfile
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param docfile the docfile to set
     */
    public void setFile(MultipartFile docfile) {
        this.file = docfile;
    }


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

}