package com.fixedAssets.domain.repository;

import com.fixedAssets.domain.AssetTypeDo;

import java.util.List;
import java.util.Optional;

public interface AssetTypeDoRepository {

    List<AssetTypeDo> getAll();
    Optional<List<AssetTypeDo>> findByTypeIdD(int typeIdD);
    AssetTypeDo save (AssetTypeDo assetTypeDo);
    void delete (int typeIdD);




}
