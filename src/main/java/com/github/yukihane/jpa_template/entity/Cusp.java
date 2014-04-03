package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Cusp implements Serializable {

    private static final long serialVersionUID = 8022003746201894737L;

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
