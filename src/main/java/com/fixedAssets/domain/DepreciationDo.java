package com.fixedAssets.domain;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class DepreciationDo {

    private Integer depreciationIdD;
    private Integer assetIdD;
    private LocalDate depreciationDateD;
    private Double depreciationValueD;
    private FixedAssetDo fixedAssetDo;


    //Getters and Setters


    public FixedAssetDo getFixedAssetDo() {
        return fixedAssetDo;
    }

    public Integer getDepreciationIdD() {
        return depreciationIdD;
    }

    public void setDepreciationIdD(Integer depreciationIdD) {
        this.depreciationIdD = depreciationIdD;
    }

    public Integer getAssetIdD() {
        return assetIdD;
    }

    public void setAssetIdD(Integer assetIdD) {
        this.assetIdD = assetIdD;
    }

    public LocalDate getDepreciationDateD() {
        return depreciationDateD;
    }

    public void setDepreciationDateD(LocalDate depreciationDateD) {
        this.depreciationDateD = depreciationDateD;
    }

    public Double getDepreciationValueD() {
        return depreciationValueD;
    }

    public void setDepreciationValueD(Double depreciationValueD) {
        this.depreciationValueD = depreciationValueD;
    }

    public FixedAssetDo getFixedAssetD() {
        return fixedAssetDo;
    }

    public void setFixedAssetDo(FixedAssetDo fixedAssetDo) {
        this.fixedAssetDo = fixedAssetDo;
    }
}
