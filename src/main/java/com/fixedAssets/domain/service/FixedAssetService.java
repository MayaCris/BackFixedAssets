package com.fixedAssets.domain.service;
import com.fixedAssets.domain.FixedAssetDo;
import com.fixedAssets.domain.repository.FixedAssetDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FixedAssetService {

    @Autowired
    private FixedAssetDoRepository fixedAssetDoRepository;

    public List<FixedAssetDo> getAll(){
        return fixedAssetDoRepository.getAll();
    }

    public List<FixedAssetDo> getAllByOrderByAcquisitionDateDAsc(){
        return fixedAssetDoRepository.getAllByOrderByAcquisitionDateDAsc();
    }

    public Optional<List<FixedAssetDo>> getByResponsiblePersonDo(String personIdD){
        return fixedAssetDoRepository.getByResponsiblePersonDo(personIdD);
    }

    public Optional<List<FixedAssetDo>> getMinimumQuantityDo(int acquisitionValueD){
        return fixedAssetDoRepository.getMinimumQuantityDo(acquisitionValueD);
}

    public FixedAssetDo save(FixedAssetDo fixedAssetDo){
        return fixedAssetDoRepository.save(fixedAssetDo);
    }

    public Optional<List<FixedAssetDo>> findByAssetIdD(int assetIdD){
        return fixedAssetDoRepository.findByAssetIdD(assetIdD);
    }

    public Boolean delete(int assetIdD){
        return findByAssetIdD(assetIdD).map(FixedAssetDo -> {
            fixedAssetDoRepository.delete(assetIdD);
            return true;
        }).orElse(false);
    }

    public FixedAssetDo update(int assetIdD,FixedAssetDo fixedAssetDoNew){
        Optional<List<FixedAssetDo>> fixedAssetDoOptional = findByAssetIdD(assetIdD);
        if (fixedAssetDoOptional.isPresent()){
            FixedAssetDo fixedAssetDoExist = fixedAssetDoOptional.get().get(0);

            if (fixedAssetDoNew.getAssetCodeD() != null){
                fixedAssetDoExist.setAssetCodeD(fixedAssetDoNew.getAssetCodeD());
            }
            if (fixedAssetDoNew.getAcquisitionDateD() != null){
                fixedAssetDoExist.setAcquisitionDateD(fixedAssetDoNew.getAcquisitionDateD());
            }
            if(fixedAssetDoNew.getAssetNameD() != null){
                fixedAssetDoExist.setAssetNameD(fixedAssetDoNew.getAssetNameD());
            }
            if (fixedAssetDoNew.getAssetDescriptionD() != null){
                fixedAssetDoExist.setAssetDescriptionD(fixedAssetDoNew.getAssetDescriptionD());
            }
            if (fixedAssetDoNew.getAcquisitionValueD() != null){
                fixedAssetDoExist.setAcquisitionValueD(fixedAssetDoNew.getAcquisitionValueD());
            }
            if (fixedAssetDoNew.getAssetTypeDo() != null) {
                fixedAssetDoExist.setAssetTypeDo(fixedAssetDoNew.getAssetTypeDo());
            }
            if(fixedAssetDoNew.getLocationIdD() != null){
                fixedAssetDoExist.setLocationIdD(fixedAssetDoNew.getLocationIdD());
            }
            if(fixedAssetDoNew.getPersonIdD() != null){
                fixedAssetDoExist.setPersonIdD(fixedAssetDoNew.getPersonIdD());
            }

            return save(fixedAssetDoExist);
        }else {
            throw new EntityNotFoundException("FixedAsset with id " + assetIdD + " not found");
        }
    }
}
