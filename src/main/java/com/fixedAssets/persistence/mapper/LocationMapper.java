package com.fixedAssets.persistence.mapper;

import com.fixedAssets.domain.LocationDo;
import com.fixedAssets.persistence.entity.Location;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mappings({
            @Mapping(source = "locationId", target = "locationIdDo"),
            @Mapping(source = "locationName", target = "locationNameD"),
            @Mapping(source = "locationAddress", target = "locationAddressD"),
            @Mapping(source = "locationCity", target = "locationCityD"),
            @Mapping(source = "locationCountry", target = "locationCountryD"),

    })
    LocationDo toLocationDo (Location location);
    List<LocationDo> toLocationDoList (List<Location> locationList);

    @InheritInverseConfiguration
    @Mapping(target = "fixedAssets", ignore = true)
    Location toLocation (LocationDo locationDo);
}
