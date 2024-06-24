package com.fixedAssets.domain.service;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.domain.repository.AssetTypeDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetTypeService {
    @Autowired
    private AssetTypeDoRepository assetTypeDoRepository;

    public List<AssetTypeDo> getAll() {
        return assetTypeDoRepository.getAll();
    }

    public Optional<List<AssetTypeDo>> findByTypeIdD(int typeIdD) {
        return assetTypeDoRepository.findByTypeIdD(typeIdD);
    }

    public AssetTypeDo save(AssetTypeDo assetTypeDo) {
        return assetTypeDoRepository.save(assetTypeDo);
    }

    public boolean delete(int typeIdD) {
        return findByTypeIdD(typeIdD).map(assetTypeDo -> {
            assetTypeDoRepository.delete(typeIdD);
            return true;
        }).orElse(false);
    }

}