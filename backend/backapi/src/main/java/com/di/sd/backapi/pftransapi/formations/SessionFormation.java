package com.di.sd.backapi.pftransapi.formations;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class SessionFormation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long value;
    @NotBlank(message = "Champ obligatoire")
    private String label;
    @ManyToOne
    @JoinColumn(name = "ID_FORMATION")
    private Formations formation;
    @ManyToOne
    @JoinColumn(name = "ID_CS")
    private CycleScolaire cycleScolaire;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateDebut;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateFin;
    private Boolean active = true;
    private Boolean planification = true;
    private String urlPlanification;

    public SessionFormation() {
    }

    /**
     * @return Long return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
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
     * @return Formations return the formation
     */
    public Formations getFormation() {
        return formation;
    }

    /**
     * @param formation the formation to set
     */
    public void setFormation(Formations formation) {
        this.formation = formation;
    }

    /**
     * @return Date return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @return Date return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "SessionFormation [dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", formation=" + formation
                + ", label=" + label + "]";
    }

    /**
     * @return Boolean return the active
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return Boolean return the planification
     */
    public Boolean isPlanification() {
        return planification;
    }

    /**
     * @param planification the planification to set
     */
    public void setPlanification(Boolean planification) {
        this.planification = planification;
    }

    /**
     * @return String return the urlPlanification
     */
    public String getUrlPlanification() {
        return urlPlanification;
    }

    /**
     * @param urlPlanification the urlPlanification to set
     */
    public void setUrlPlanification(String urlPlanification) {
        this.urlPlanification = urlPlanification;
    }

    /**
     * @return CycleScolaire return the cycleScolaire
     */
    public CycleScolaire getCycleScolaire() {
        return cycleScolaire;
    }

    /**
     * @param cycleScolaire the cycleScolaire to set
     */
    public void setCycleScolaire(CycleScolaire cycleScolaire) {
        this.cycleScolaire = cycleScolaire;
    }

}
