package com.fixedAssets.persistence.crud;

import com.fixedAssets.persistence.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LocationCrudRepository extends CrudRepository<Location,Integer> {

    Optional<List<Location>> findByLocationId(Integer locationId);
    Optional<List<Location>> findByLocationCity(String locationCity);
}
