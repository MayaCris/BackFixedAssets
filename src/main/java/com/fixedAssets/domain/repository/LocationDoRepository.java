package com.fixedAssets.domain.repository;

import com.fixedAssets.domain.LocationDo;

import java.util.List;
import java.util.Optional;

public interface LocationDoRepository {

    List<LocationDo> getAll();
    Optional<List<LocationDo>> getByLocationCityD(String locationCityD);
    Optional<List<LocationDo>> findByLocationIdDo(Integer locationIdDo);
    LocationDo saveLocation(LocationDo locationDo);
    void deleteLocation(Integer locationIdDo);

}
