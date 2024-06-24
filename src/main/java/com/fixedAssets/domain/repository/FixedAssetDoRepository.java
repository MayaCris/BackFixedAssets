package com.fixedAssets.domain.repository;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.domain.FixedAssetDo;
import com.fixedAssets.persistence.entity.FixedAsset;

import java.util.List;
import java.util.Optional;

public interface FixedAssetDoRepository {

    List<FixedAssetDo> getAll();
    Optional<List<FixedAssetDo>> getByResponsiblePersonDo(String personIdD);
    Optional<List<FixedAssetDo>> getMinimumQuantityDo (int acquisitionValueD);
    Optional<List<FixedAssetDo>> findByAssetIdD(int assetIdD);
    FixedAssetDo save(FixedAssetDo fixedAssetDo);
    void delete(int assetIdD);
    List<FixedAssetDo> getAllByOrderByAcquisitionDateDAsc();
}
