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
    
    @OneToOne(mappedBy = "head", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, optional=false)
    private Bridge bridge;

    @OneToOne(mappedBy = "head", cascade = CascadeType.ALL, orphanRemoval = true, optional = true)
    private OptionalBranch optionalBranch;

    private String name;
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
