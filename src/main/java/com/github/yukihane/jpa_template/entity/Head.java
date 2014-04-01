package com.github.yukihane.jpa_template.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Head {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @OneToOne(mappedBy = "head", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional = false)
    private Bridge bridge;

    @OneToOne(mappedBy = "head", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private OptionalBranch optionalBranch;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
        bridge.setHead(this);
    }

    public OptionalBranch getOptionalBranch() {
        return optionalBranch;
    }

    public void setOptionalBranch(OptionalBranch optionalBranch) {
        this.optionalBranch = optionalBranch;
        optionalBranch.setHead(this);
    }

}
