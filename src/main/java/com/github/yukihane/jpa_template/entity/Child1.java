package com.github.yukihane.jpa_template.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
public class Child1 extends Parent {

    private static final long serialVersionUID = 9185097301490891171L;

    @Embedded
    private Emb emb;

    private String name;

    public Child1() {
    }

    public Child1(String name) {
        this.name = name;
    }

    public Emb getEmb() {
        return emb;
    }

    public void setEmb(Emb emb) {
        this.emb = emb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
