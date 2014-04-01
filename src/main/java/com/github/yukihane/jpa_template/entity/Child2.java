package com.github.yukihane.jpa_template.entity;

import javax.persistence.Entity;

@Entity
public class Child2 extends Parent {

    private static final long serialVersionUID = -445560668737306467L;

    private String name;

    public Child2() {
    }

    public Child2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
