package com.fixedAssets.domain.service;

import com.fixedAssets.domain.LocationDo;
import com.fixedAssets.domain.repository.LocationDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationDoRepository locationDoRepository;

    public List<LocationDo> getAll() {
        return locationDoRepository.getAll();
    }

    public Optional<List<LocationDo>> getByLocationCityD(String locationCityD) {
        return locationDoRepository.getByLocationCityD(locationCityD);
    }

    public LocationDo saveLocation(LocationDo locationDo) {
        return locationDoRepository.saveLocation(locationDo);
    }

    public Optional<List<LocationDo>> findByLocationIdDo(Integer locationIdDo) {
        return locationDoRepository.findByLocationIdDo(locationIdDo);
    }

    public boolean deleteLocation(Integer locationIdDo) {
      return findByLocationIdDo(locationIdDo).map(location -> {
          locationDoRepository.deleteLocation(locationIdDo);
          return true;
      }).orElse(false);
    }
}
