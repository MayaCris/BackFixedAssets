package com.fixedAssets.persistence;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.domain.repository.AssetTypeDoRepository;
import com.fixedAssets.persistence.crud.AssetTypeCrudRepository;
import com.fixedAssets.persistence.entity.AssetType;
import com.fixedAssets.persistence.mapper.AssetTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class AssetTypeRepository implements AssetTypeDoRepository {

    @Autowired
    private AssetTypeCrudRepository assetTypeCrudRepository;
    @Autowired
    private AssetTypeMapper mapper;

    @Override
    public List<AssetTypeDo> getAll(){
        List<AssetType> assetTypes = (List<AssetType>) assetTypeCrudRepository.findAll();
        return mapper.toAssetTypeDoList(assetTypes);
    }

    @Override
    public Optional<List<AssetTypeDo>> findByTypeIdD(int typeIdD) {
        Optional<AssetType> assetTypes = assetTypeCrudRepository.findById(typeIdD);
        return assetTypes.map(assetType -> Collections.singletonList(mapper.toAssetTypeDo(assetType)));
    }

    @Override
    public AssetTypeDo save(AssetTypeDo assetTypeDo) {
        AssetType assetType = mapper.toAssetType(assetTypeDo);
        return mapper.toAssetTypeDo(assetTypeCrudRepository.save(assetType));
    }

    @Override
    public void delete(int typeIdD) {
        assetTypeCrudRepository.deleteById(typeIdD);
    }

}
