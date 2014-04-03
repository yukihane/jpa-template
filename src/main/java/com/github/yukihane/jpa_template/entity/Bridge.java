package com.github.yukihane.jpa_template.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.BatchSize;

@Entity
public class Bridge implements Serializable {

    private static final long serialVersionUID = 5906743863161701206L;

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @OneToOne(optional = false)
    @JoinColumn(name = "HEAD_ID", referencedColumnName = "ID")
    private Head head;

    @OneToMany(mappedBy = "bridge", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @BatchSize(size=16)
    private Set<Parent> parents = new HashSet<Parent>();

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

    public Set<Parent> getParents() {
        return parents;
    }

    public void addParents(Parent... parents) {
        for (Parent p : parents) {
            this.parents.add(p);
            p.setBridge(this);
        }
    }

}
