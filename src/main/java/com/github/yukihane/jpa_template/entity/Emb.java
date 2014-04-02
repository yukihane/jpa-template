package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Emb implements Serializable {

    private static final long serialVersionUID = 7572129114421795786L;

    private String embProperty;

    public String getEmbProperty() {
        return embProperty;
    }

    public void setEmbProperty(String embProperty) {
        this.embProperty = embProperty;
    }

}
