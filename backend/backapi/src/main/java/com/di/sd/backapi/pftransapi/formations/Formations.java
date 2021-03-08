package com.di.sd.backapi.pftransapi.formations;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Formations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Champ obligatoire")
    private String label;
    @NotBlank(message = "Champ obligatoire")
    private String reference;
    @NotBlank(message = "Champ obligatoire")

    private String compositionDossier;
    @NotBlank(message = "Champ obligatoire")

    private String conditions;
    private String noteDeBase;
    @Transient
    private MultipartFile file;
    @ManyToOne
    @JoinColumn(name = "ID_TYPEFORMATION")
    private TypeFormation typeFormation;
    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIEFORMATION")
    private CategorieFormation categorieFormation;
    @ManyToOne
    @JoinColumn(name = "ID_ETABLISSEMENT")
    private Etablissement etablissement;
    @OneToMany(mappedBy = "formation")
    @JsonProperty(access = Access.WRITE_ONLY)
    private List<SessionFormation> sessions;

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
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return String return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return String return the compositionDossier
     */
    public String getCompositionDossier() {
        return compositionDossier;
    }

    /**
     * @param compositionDossier the compositionDossier to set
     */
    public void setCompositionDossier(String compositionDossier) {
        this.compositionDossier = compositionDossier;
    }

    /**
     * @return String return the noteDeBase
     */
    public String getNoteDeBase() {
        return noteDeBase;
    }

    /**
     * @param noteDeBase the noteDeBase to set
     */
    public void setNoteDeBase(String noteDeBase) {
        this.noteDeBase = noteDeBase;
    }

    /**
     * @return MultipartFile return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return TypeFormation return the typeFormation
     */
    public TypeFormation getTypeFormation() {
        return typeFormation;
    }

    /**
     * @param typeFormation the typeFormation to set
     */
    public void setTypeFormation(TypeFormation typeFormation) {
        this.typeFormation = typeFormation;
    }

    /**
     * @return CategorieFormation return the categorieFormation
     */
    public CategorieFormation getCategorieFormation() {
        return categorieFormation;
    }

    /**
     * @param categorieFormation the categorieFormation to set
     */
    public void setCategorieFormation(CategorieFormation categorieFormation) {
        this.categorieFormation = categorieFormation;
    }

    /**
     * @return Etablissement return the etablissement
     */
    public Etablissement getEtablissement() {
        return etablissement;
    }

    /**
     * @param etablissement the etablissement to set
     */
    public void setEtablissement(Etablissement etablissement) {
        this.etablissement = etablissement;
    }

    /**
     * @return List<SessionFormation> return the sessions
     */
    public List<SessionFormation> getSessions() {
        return sessions;
    }

    /**
     * @param sessions the sessions to set
     */
    public void setSessions(List<SessionFormation> sessions) {
        this.sessions = sessions;
    }

    public Formations() {
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

}