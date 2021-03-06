package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class OptionalBranch implements Serializable {

    private static final long serialVersionUID = 4070110373063847883L;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @OneToOne(optional = false)
    @JoinColumn(name = "HEAD_ID", referencedColumnName = "ID")
    private Head head;

    private String name;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
