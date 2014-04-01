package com.github.yukihane.jpa_template.entity;

import javax.persistence.Entity;

@Entity
public class Child1 extends Parent {

    private static final long serialVersionUID = 9185097301490891171L;

    private String name;

    public Child1() {
    }

    public Child1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
