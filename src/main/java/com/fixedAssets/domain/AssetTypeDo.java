package com.fixedAssets.domain;

import com.fixedAssets.persistence.entity.FixedAsset;

public class AssetTypeDo {
    private Integer typeIdD;
    private String typeNameD;
    private Integer depreciationTimeD;


    //Getters and Setters


    public Integer getTypeIdD() {
        return typeIdD;
    }

    public void setTypeIdD(Integer typeIdD) {
        this.typeIdD = typeIdD;
    }

    public String getTypeNameD() {
        return typeNameD;
    }

    public void setTypeNameD(String typeNameD) {
        this.typeNameD = typeNameD;
    }

    public Integer getDepreciationTimeD() {
        return depreciationTimeD;
    }

    public void setDepreciationTimeD(Integer depreciationTimeD) {
        this.depreciationTimeD = depreciationTimeD;
    }
}
