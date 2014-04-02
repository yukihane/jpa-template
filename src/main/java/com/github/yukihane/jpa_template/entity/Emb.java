package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class Emb implements Serializable {

    private static final long serialVersionUID = 7572129114421795786L;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "CUSP_ID", referencedColumnName = "ID")
    private Cusp cusp;

    private String embProperty;

    public Emb() {
    }

    public Emb(String embProperty) {
        this.embProperty = embProperty;
    }

    public String getEmbProperty() {
        return embProperty;
    }

    public void setEmbProperty(String embProperty) {
        this.embProperty = embProperty;
    }

    public Cusp getCusp() {
        return cusp;
    }

    public void setCusp(Cusp cusp) {
        this.cusp = cusp;
    }

}
