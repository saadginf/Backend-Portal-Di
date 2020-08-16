package com.di.sd.backapi.modals;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ThemeDoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long value;
    private String label;
    @OneToMany(mappedBy = "themeDoc")
    List<SousTheme> sousThemes;

    public ThemeDoc() {
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

    public List<SousTheme> getSousThemes() {
        return sousThemes;
    }

    public void setSousThemes(List<SousTheme> sousThemes) {
        this.sousThemes = sousThemes;
    }

}
