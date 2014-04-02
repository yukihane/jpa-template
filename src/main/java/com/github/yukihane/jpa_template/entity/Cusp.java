package com.github.yukihane.jpa_template.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Cusp {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private String cuspProperty;

    public Cusp() {
    }

    public Cusp(String cuspProperty) {
        this.cuspProperty = cuspProperty;
    }

    public String getCuspProperty() {
        return cuspProperty;
    }

    public void setCuspProperty(String cuspProperty) {
        this.cuspProperty = cuspProperty;
    }
}
