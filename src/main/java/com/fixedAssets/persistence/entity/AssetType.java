package com.fixedAssets.persistence.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ASSET_TYPE")
public class AssetType {

    @Id
    @Column(name = "TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @Column(name = "TYPE_NAME")
    private String typeName;

    public List<FixedAsset> getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(List<FixedAsset> fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    @Column(name = "DEPRECIATION_TIME_MONTHS")
    private Integer depreciationTime;

    @OneToMany(mappedBy = "assetType")
    private List<FixedAsset> fixedAssets;

    //Getters and Setters


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getDepreciationTime() {
        return depreciationTime;
    }

    public void setDepreciationTime(Integer depreciationTime) {
        this.depreciationTime = depreciationTime;
    }
}
