package com.fixedAssets.domain.repository;

import com.fixedAssets.domain.DepreciationDo;

import java.util.List;
import java.util.Optional;

public interface DepreciationDoRepository {
    List<DepreciationDo> getAll();
    Optional<List<DepreciationDo>> findByDepreciationIdD(int DepreciationIdD);
    Optional<List<DepreciationDo>> findByAssetIdD (int assetIdD);
    void delete (int depreciationIdD);
    DepreciationDo save(DepreciationDo depreciationDo);

}
