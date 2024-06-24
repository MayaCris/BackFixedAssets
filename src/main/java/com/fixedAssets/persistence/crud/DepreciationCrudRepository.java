package com.fixedAssets.persistence.crud;

import com.fixedAssets.persistence.entity.Depreciation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DepreciationCrudRepository extends CrudRepository<Depreciation, Integer> {

    Optional<List<Depreciation>> findByDepreciationId (int assetId);
    Optional<List<Depreciation>> findByAssetId (int assetId);
}
