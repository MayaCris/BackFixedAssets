package com.fixedAssets.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "FIXED_ASSETS")
public class FixedAsset {

    @Id
    @Column(name = "ASSET_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetId;

    @Column(name = "ASSET_COD")
    private String assetCode;

    @Column(name = "ASSET_NAME")
    private String assetName;

    @Column(name = "ASSET_DESCRIPTION")
    private String assetDescription;

    @Column(name = "TYPE_ID")
    private Integer typeId;

    @Column(name = "ACQUISITION_DATE")
    private LocalDate acquisitionDate;

    @Column(name = "ACQUISITION_VALUE")
    private Double acquisitionValue;

    @Column(name = "LOCATION_ID")
    private Integer locationId;

    @Column(name = "PERSON_ID")
    private String personId;

    @OneToMany(mappedBy = "fixedAsset", cascade = {CascadeType.ALL})
    private List<Depreciation> depreciations;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID", insertable = false, updatable = false)
    private ResponsiblePerson responsiblePerson;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", insertable = false, updatable = false)
    private AssetType assetType;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID", insertable = false, updatable = false)
    private Location location;

    //Getters and Setters


    public List<Depreciation> getDepreciations() {
        return depreciations;
    }

    public void setDepreciations(List<Depreciation> depreciations) {
        this.depreciations = depreciations;
    }

    public ResponsiblePerson getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(ResponsiblePerson responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public AssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }

    public String getAssetCode() {
        return assetCode;
    }

    public void setAssetCode(String assetCode) {
        this.assetCode = assetCode;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public LocalDate getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(LocalDate acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Double getAcquisitionValue() {
        return acquisitionValue;
    }

    public void setAcquisitionValue(Double acquisitionValue) {
        this.acquisitionValue = acquisitionValue;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
