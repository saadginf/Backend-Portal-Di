package com.di.sd.backapi.pftransapi.personnel;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.di.sd.backapi.pftransapi.grade.GradeAvoir;
import com.di.sd.backapi.pftransapi.infom.EchelleSoldeAvoir;
import com.di.sd.backapi.pftransapi.infom.FonctionAvoir;
import com.di.sd.backapi.pftransapi.infom.NiveauInstruction;
import com.di.sd.backapi.pftransapi.infom.Notation;
import com.di.sd.backapi.pftransapi.infom.OriginePerso;
import com.di.sd.backapi.pftransapi.infom.Penalisation;
import com.di.sd.backapi.pftransapi.infom.Position;
import com.di.sd.backapi.pftransapi.infom.Specialite;
import com.di.sd.backapi.pftransapi.unites.UniteAffAvoir;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Personnel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Ce Champ est obligatoire")
    private String nom;
    @NotBlank(message = "Ce Champ est obligatoire")
    private String prenom;
    @NotBlank(message = "Ce Champ est obligatoire")
    private String cin;
    @NotBlank(message = " Ce Champ est obligatoire")
    private String mle;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateNaissance;
    @JsonFormat(pattern ="yyyy-MM-dd" )
    private Date dateEntreeService;
    private Boolean apptitudePhysique;
    private String photo;
    private String obs;

    @ManyToOne
    @JoinColumn(name="ID_NVINST")
    private NiveauInstruction nvInstruction;
    @ManyToOne
    @JoinColumn(name="ID_POS")
    private Position position;
    @ManyToOne
    @JoinColumn(name="ID_SPECIALITE")
    private Specialite specialite;
    @ManyToOne
    @JoinColumn(name="ID_ORIGINE")
    private OriginePerso origine;
    @OneToMany(mappedBy = "personel")
    private List<Penalisation> penalisations;
    @OneToMany(mappedBy = "personel")
    private List<Notation> notations;
    @OneToMany(mappedBy = "personel")
    private List<EchelleSoldeAvoir> echelleSoldeAvoirs;
    @OneToMany(mappedBy = "personel")
    private List<GradeAvoir> gradeAvoirs;
    @OneToMany(mappedBy = "personel")
    private List<UniteAffAvoir> uniteAffAvoirs;
    @OneToMany(mappedBy = "personel")
    private List<FonctionAvoir> fonctionAvoirs;


    
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
     * @return String return the cin
     */
    public String getCin() {
        return cin;
    }

    /**
     * @param cin the cin to set
     */
    public void setCin(String cin) {
        this.cin = cin;
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
     * @return Date return the dateNaissance
     */
    public Date getDateNaissance() {
        return dateNaissance;
    }

    /**
     * @param dateNaissance the dateNaissance to set
     */
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    /**
     * @return Date return the dateEntreeService
     */
    public Date getDateEntreeService() {
        return dateEntreeService;
    }

    /**
     * @param dateEntreeService the dateEntreeService to set
     */
    public void setDateEntreeService(Date dateEntreeService) {
        this.dateEntreeService = dateEntreeService;
    }

    /**
     * @return Boolean return the apptitudePhysique
     */
    public Boolean isApptitudePhysique() {
        return apptitudePhysique;
    }

    /**
     * @param apptitudePhysique the apptitudePhysique to set
     */
    public void setApptitudePhysique(Boolean apptitudePhysique) {
        this.apptitudePhysique = apptitudePhysique;
    }

    /**
     * @return String return the photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param photo the photo to set
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * @return String return the obs
     */
    public String getObs() {
        return obs;
    }

    /**
     * @param obs the obs to set
     */
    public void setObs(String obs) {
        this.obs = obs;
    }

    /**
     * @return NiveauInstruction return the nvInstruction
     */
    public NiveauInstruction getNvInstruction() {
        return nvInstruction;
    }

    /**
     * @param nvInstruction the nvInstruction to set
     */
    public void setNvInstruction(NiveauInstruction nvInstruction) {
        this.nvInstruction = nvInstruction;
    }

    /**
     * @return Position return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return Specialite return the specialite
     */
    public Specialite getSpecialite() {
        return specialite;
    }

    /**
     * @param specialite the specialite to set
     */
    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    /**
     * @return Origine return the origine
     */
    public OriginePerso getOrigine() {
        return origine;
    }

    /**
     * @param origine the origine to set
     */
    public void setOrigine(OriginePerso origine) {
        this.origine = origine;
    }

    /**
     * @return List<Penalisation> return the penalisations
     */
    public List<Penalisation> getPenalisations() {
        return penalisations;
    }

    /**
     * @param penalisations the penalisations to set
     */
    public void setPenalisations(List<Penalisation> penalisations) {
        this.penalisations = penalisations;
    }

    /**
     * @return List<Notation> return the notations
     */
    public List<Notation> getNotations() {
        return notations;
    }

    /**
     * @param notations the notations to set
     */
    public void setNotations(List<Notation> notations) {
        this.notations = notations;
    }

    public Personnel() {
    }


    /**
     * @return List<EchelleSoldeAvoir> return the echelleSoldeAvoirs
     */
    public List<EchelleSoldeAvoir> getEchelleSoldeAvoirs() {
        return echelleSoldeAvoirs;
    }

    /**
     * @param echelleSoldeAvoirs the echelleSoldeAvoirs to set
     */
    public void setEchelleSoldeAvoirs(List<EchelleSoldeAvoir> echelleSoldeAvoirs) {
        this.echelleSoldeAvoirs = echelleSoldeAvoirs;
    }

    /**
     * @return List<GradeAvoir> return the gradeAvoirs
     */
    public List<GradeAvoir> getGradeAvoirs() {
        return gradeAvoirs;
    }

    /**
     * @param gradeAvoirs the gradeAvoirs to set
     */
    public void setGradeAvoirs(List<GradeAvoir> gradeAvoirs) {
        this.gradeAvoirs = gradeAvoirs;
    }

    /**
     * @return List<UniteAffAvoir> return the uniteAffAvoirs
     */
    public List<UniteAffAvoir> getUniteAffAvoirs() {
        return uniteAffAvoirs;
    }

    /**
     * @param uniteAffAvoirs the uniteAffAvoirs to set
     */
    public void setUniteAffAvoirs(List<UniteAffAvoir> uniteAffAvoirs) {
        this.uniteAffAvoirs = uniteAffAvoirs;
    }

    /**
     * @return List<FonctionAvoir> return the fonctionAvoirs
     */
    public List<FonctionAvoir> getFonctionAvoirs() {
        return fonctionAvoirs;
    }

    /**
     * @param fonctionAvoirs the fonctionAvoirs to set
     */
    public void setFonctionAvoirs(List<FonctionAvoir> fonctionAvoirs) {
        this.fonctionAvoirs = fonctionAvoirs;
    }

}