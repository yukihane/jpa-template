package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CHILD_TYPE", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class Parent implements Serializable {

    private static final long serialVersionUID = 2764874252168440857L;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @ManyToOne
    @JoinColumn(name = "BRIDGE_ID", referencedColumnName = "ID")
    private Bridge bridge;

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public Bridge getBridge() {
        return bridge;
    }

}
