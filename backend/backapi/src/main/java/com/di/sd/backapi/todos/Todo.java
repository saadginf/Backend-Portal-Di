package com.di.sd.backapi.todos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import com.di.sd.backapi.modals.Unite;
import javax.validation.constraints.NotBlank;
import javax.persistence.PrePersist;
import java.util.Date;
import javax.persistence.Column;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long value;
    @NotBlank(message = "Champ obligatoire")
    private String label;

    private Boolean done = false;
    @ManyToOne
    @JoinColumn(name = "ID_UNITE")
    private Unite unite;
    @JsonFormat(pattern = "yyyy-mm-dd")
    @Column(updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
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
     * @return Boolean return the done
     */
    public Boolean isDone() {
        return done;
    }

    /**
     * @param done the done to set
     */
    public void setDone(Boolean done) {
        this.done = done;
    }

    public Todo() {
    }

    /**
     * @return Unite return the unite
     */
    public Unite getUnite() {
        return unite;
    }

    /**
     * @param unite the unite to set
     */
    public void setUnite(Unite unite) {
        this.unite = unite;
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

}
