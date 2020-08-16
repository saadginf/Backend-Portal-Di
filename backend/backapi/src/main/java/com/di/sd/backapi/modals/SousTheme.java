package com.di.sd.backapi.modals;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class SousTheme {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long value;
private String label;
@ManyToOne
@JoinColumn(name="ID_THEME")
@JsonProperty(access = Access.WRITE_ONLY)
private ThemeDoc themeDoc;
@OneToMany(mappedBy = "sousTheme")
@JsonProperty(access = Access.WRITE_ONLY)
private List<Document> documents;
public SousTheme() {
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
     * @return Long return the label
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
     * @return ThemeDoc return the themeDoc
     */
    public ThemeDoc getThemeDoc() {
        return themeDoc;
    }

    /**
     * @param themeDoc the themeDoc to set
     */
    public void setThemeDoc(ThemeDoc themeDoc) {
        this.themeDoc = themeDoc;
    }


    /**
     * @return List<Document> return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * @param documents the documents to set
     */
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

}
