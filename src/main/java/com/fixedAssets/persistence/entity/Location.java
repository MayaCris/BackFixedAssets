package com.fixedAssets.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "LOCATIONS")
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer locationId;

    @Column(name = "LOCATION_NAME")
    private String locationName;

    @Column(name = "LOCATION_ADDRESS")
    private String locationAddress;

    @Column(name = "LOCATION_CITY")
    private String locationCity;

    @Column(name = "LOCATION_COUNTRY")
    private String locationCountry;

    @OneToMany(mappedBy = "location")
    private List<FixedAsset> fixedAssets;


    //Getters and Setters


    public List<FixedAsset> getFixedAssets() {
        return fixedAssets;
    }

    public void setFixedAssets(List<FixedAsset> fixedAssets) {
        this.fixedAssets = fixedAssets;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }
}
