package com.fixedAssets.persistence;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.domain.FixedAssetDo;
import com.fixedAssets.domain.repository.FixedAssetDoRepository;
import com.fixedAssets.persistence.crud.FixedAssetCrudRepository;
import com.fixedAssets.persistence.entity.AssetType;
import com.fixedAssets.persistence.entity.FixedAsset;
import com.fixedAssets.persistence.mapper.FixedAssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class FixedAssetRepository implements FixedAssetDoRepository {

    @Autowired
    private FixedAssetCrudRepository fixedAssetCrudRepository;
    @Autowired
    private FixedAssetMapper mapper;

    @Override
    public List<FixedAssetDo> getAll(){
         List<FixedAsset> fixedAssets = (List<FixedAsset>) fixedAssetCrudRepository.findAll();
        return mapper.toFixedAssetDoList(fixedAssets);
    }

    @Override
    public List<FixedAssetDo> getAllByOrderByAcquisitionDateDAsc(){
        List<FixedAsset> fixedAssets = (List<FixedAsset>) fixedAssetCrudRepository.findAllByOrderByAcquisitionDateAsc();
        return mapper.toFixedAssetDoList(fixedAssets);
    }

    @Override
    public Optional<List<FixedAssetDo>> getByResponsiblePersonDo(String personIdD) {
        return fixedAssetCrudRepository.findByPersonIdOrderByAssetNameAsc(personIdD).map(fixedAssets -> mapper.toFixedAssetDoList(fixedAssets));
    }

    @Override
    public Optional<List<FixedAssetDo>> getMinimumQuantityDo(int acquisitionValueD) {
        return fixedAssetCrudRepository.findByAcquisitionValueLessThan(acquisitionValueD).map(fixedAssets -> mapper.toFixedAssetDoList(fixedAssets));
    }

    @Override
    public FixedAssetDo save(FixedAssetDo fixedAssetDo) {
        FixedAsset fixedAsset = mapper.toFixedAsset(fixedAssetDo);
        return mapper.toFixedAssetDo(fixedAssetCrudRepository.save(fixedAsset));
    }
    @Override
    public Optional<List<FixedAssetDo>> findByAssetIdD(int assetIdD) {
        Optional<FixedAsset> fixedAssets = fixedAssetCrudRepository.findById(assetIdD);
        return fixedAssets.map(fixedAsset -> Collections.singletonList(mapper.toFixedAssetDo(fixedAsset)));
    }

    @Override
    public void delete(int assetIdD) {
        fixedAssetCrudRepository.deleteById(assetIdD);
    }





}
