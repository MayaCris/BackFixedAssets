package com.fixedAssets.persistence.crud;

import com.fixedAssets.persistence.entity.FixedAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

import java.util.List;


public interface FixedAssetCrudRepository extends CrudRepository<FixedAsset, Integer> {


    //Query Method para Lista de activos que estén asignados a una persona en especifico
    Optional<List<FixedAsset>> findByPersonIdOrderByAssetNameAsc(String personId);
    //@Query(value = "SELECT * FROM FIXED_ASSETS WHERE PERSON_ID = ?", nativeQuery = true);

    //Lista de activos con valor de adquisicion menor a 50 UVT $2.353.250
    Optional<List<FixedAsset>> findByAcquisitionValueLessThan(int acquisitionValue);

    //Lista total de activos ordenada por fecha de creación
    List<FixedAsset> findAllByOrderByAcquisitionDateAsc();
}
