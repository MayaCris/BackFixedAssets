package com.fixedAssets.persistence.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "RESPONSIBLE_PERSON")
public class ResponsiblePerson {

    @Id
    @Column(name = "PERSON_ID")
    private String personId;

    @Column(name = "PERSON_NAME")
    private String personName;

    @Column(name = "PERSON_DEPARTMENT")
    private String personDepartment;

    @OneToMany(mappedBy = "responsiblePerson")
    private List<FixedAsset> fixedAssets;


    //Getters and Setters


    public List<FixedAsset> getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(List<FixedAsset> fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonDepartment() {
        return personDepartment;
    }

    public void setPersonDepartment(String personDepartment) {
        this.personDepartment = personDepartment;
    }
}
