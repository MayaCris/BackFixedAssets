package com.fixedAssets.persistence;

import com.fixedAssets.domain.DepreciationDo;
import com.fixedAssets.domain.repository.DepreciationDoRepository;
import com.fixedAssets.persistence.crud.DepreciationCrudRepository;
import com.fixedAssets.persistence.entity.Depreciation;
import com.fixedAssets.persistence.mapper.DepreciationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepreciationRepository implements DepreciationDoRepository {

    @Autowired
    private DepreciationCrudRepository depreciationCrudRepository;
    @Autowired
    private DepreciationMapper mapper;

    @Override
    public List<DepreciationDo> getAll() {
        List<Depreciation> depreciations = (List<Depreciation>) depreciationCrudRepository.findAll();
        return mapper.toDepreciationDoList(depreciations);
    }

    @Override
    public Optional<List<DepreciationDo>> findByDepreciationIdD (int DepreciationIdD) {
        return depreciationCrudRepository.findByDepreciationId(DepreciationIdD).map(depreciations -> mapper.toDepreciationDoList(depreciations));
    }

    @Override
    public Optional<List<DepreciationDo>> findByAssetIdD(int assetIdD) {
        return depreciationCrudRepository.findByAssetId(assetIdD).map(depreciations -> mapper.toDepreciationDoList(depreciations));
    }

    @Override
    public void delete(int depreciationIdD) {
        depreciationCrudRepository.deleteById(depreciationIdD);
    }

    @Override
    public DepreciationDo save(DepreciationDo depreciationDo) {
        Depreciation depreciation = mapper.toDepreciation(depreciationDo);
        return mapper.toDepreciationDo(depreciationCrudRepository.save(depreciation));
    }



}
