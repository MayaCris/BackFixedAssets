package com.fixedAssets.persistence;

import com.fixedAssets.domain.LocationDo;
import com.fixedAssets.domain.repository.LocationDoRepository;
import com.fixedAssets.persistence.crud.LocationCrudRepository;
import com.fixedAssets.persistence.entity.Location;
import com.fixedAssets.persistence.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class LocationRepository implements LocationDoRepository {
    @Autowired
    LocationCrudRepository locationCrudRepository;

    @Autowired
    private LocationMapper mapper;

    @Override
    public List<LocationDo> getAll() {
        return mapper.toLocationDoList((List<Location>) locationCrudRepository.findAll());
    }

    @Override
    public Optional<List<LocationDo>> getByLocationCityD(String locationCityD) {
        return locationCrudRepository.findByLocationCity(locationCityD).map(locations -> mapper.toLocationDoList(locations));
    }

    @Override
    public Optional<List<LocationDo>> findByLocationIdDo(Integer locationId) {
        return locationCrudRepository.findByLocationId(locationId).map(locations -> mapper.toLocationDoList(locations));
    }

    @Override
    public LocationDo saveLocation(LocationDo locationDo) {
        Location location = mapper.toLocation(locationDo);
        return mapper.toLocationDo(locationCrudRepository.save(location));
    }

    @Override
    public void deleteLocation(Integer locationIdD) {
        locationCrudRepository.deleteById(locationIdD);
    }
}
