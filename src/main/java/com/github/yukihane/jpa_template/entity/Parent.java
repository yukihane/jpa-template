package com.github.yukihane.jpa_template.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
