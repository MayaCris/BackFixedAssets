package com.fixedAssets.domain;


import java.time.LocalDate;

public class FixedAssetDo {
    private Integer assetIdD;
    private String assetCodeD;
    private String assetNameD;
    private String assetDescriptionD;
    private Integer typeIdD;
    private LocalDate acquisitionDateD;
    private Double acquisitionValueD;
    private Integer locationIdD;
    private String personIdD;
    private ResponsiblePersonDo responsiblePersonDo;
    private AssetTypeDo assetTypeDo;
    private LocationDo locationDo;

    //Getters and Setters


    public Integer getAssetIdD() {
        return assetIdD;
    }

    public void setAssetIdD(Integer assetIdD) {
        this.assetIdD = assetIdD;
    }

    public String getAssetCodeD() {
        return assetCodeD;
    }

    public void setAssetCodeD(String assetCodeD) {
        this.assetCodeD = assetCodeD;
    }

    public String getAssetNameD() {
        return assetNameD;
    }

    public void setAssetNameD(String assetNameD) {
        this.assetNameD = assetNameD;
    }

    public String getAssetDescriptionD() {
        return assetDescriptionD;
    }

    public void setAssetDescriptionD(String assetDescriptionD) {
        this.assetDescriptionD = assetDescriptionD;
    }

    public Integer getTypeIdD() {
        return typeIdD;
    }

    public void setTypeIdD(Integer typeIdD) {
        this.typeIdD = typeIdD;
    }

    public Double getAcquisitionValueD() {
        return acquisitionValueD;
    }

    public void setAcquisitionValueD(Double acquisitionValueD) {
        this.acquisitionValueD = acquisitionValueD;
    }

    public Integer getLocationIdD() {
        return locationIdD;
    }

    public void setLocationIdD(Integer locationIdD) {
        this.locationIdD = locationIdD;
    }

    public String getPersonIdD() {
        return personIdD;
    }

    public void setPersonIdD(String personIdD) {
        this.personIdD = personIdD;
    }

    public ResponsiblePersonDo getResponsiblePersonDo() {
        return responsiblePersonDo;
    }

    public void setResponsiblePersonDo(ResponsiblePersonDo responsiblePersonDo) {
        this.responsiblePersonDo = responsiblePersonDo;
    }

    public LocalDate getAcquisitionDateD() {
        return acquisitionDateD;
    }

    public void setAcquisitionDateD(LocalDate acquisitionDateD) {
        this.acquisitionDateD = acquisitionDateD;
    }

    public AssetTypeDo getAssetTypeDo() {
        return assetTypeDo;
    }

    public void setAssetTypeDo(AssetTypeDo assetTypeDo) {
        this.assetTypeDo = assetTypeDo;
    }

    public LocationDo getLocationDo() {
        return locationDo;
    }

    public void setLocationDo(LocationDo locationDo) {
        this.locationDo = locationDo;
    }
}
