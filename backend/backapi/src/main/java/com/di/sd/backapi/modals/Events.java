package com.di.sd.backapi.modals;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;


@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Titre Obligatoire")
    private String title;
    private String bgColor;
    @Column(name="start_date")
    @NotBlank(message = "Date Obligatoire")
    String  start;
    @Column(name="end_date")
    @NotBlank(message = "Date Obligatoire")
    String  end;
    @ManyToOne
    @JoinColumn(name="ID_UNITE")
    private Unite unite;
    private String descrptif;
    @ManyToOne
    @JoinColumn(name="ID_Type_EVENT")
    private TypeEvent typeEvent;
    
    public Events() {
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
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the bgColor
     */
    public String getBgColor() {
        return bgColor;
    }

    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
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
     * @return String return the descrptif
     */
    public String getDescrptif() {
        return descrptif;
    }

    /**
     * @param descrptif the descrptif to set
     */
    public void setDescrptif(String descrptif) {
        this.descrptif = descrptif;
    }

    /**
     * @return TypeEvent return the typeEvent
     */
    public TypeEvent getTypeEvent() {
        return typeEvent;
    }

    /**
     * @param typeEvent the typeEvent to set
     */
    public void setTypeEvent(TypeEvent typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

}