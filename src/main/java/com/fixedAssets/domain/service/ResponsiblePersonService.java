package com.fixedAssets.domain.service;

import com.fixedAssets.domain.DepreciationDo;
import com.fixedAssets.domain.ResponsiblePersonDo;
import com.fixedAssets.domain.repository.ResponsiblePersonDoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsiblePersonService {

    @Autowired
    ResponsiblePersonDoRepository responsiblePersonDoRepository;

    public List<ResponsiblePersonDo> getAll() {
        return responsiblePersonDoRepository.getAll();
    }

    public Optional<List<ResponsiblePersonDo>> getBypersonIdD(String personIdD) {
        return responsiblePersonDoRepository.getBypersonIdD(personIdD);
    }

    public ResponsiblePersonDo savePerson(ResponsiblePersonDo responsiblePersonDo) {
        return responsiblePersonDoRepository.savePerson(responsiblePersonDo);
    }

    public boolean deletePerson(String personIdD) {
      return getBypersonIdD(personIdD).map(responsiblePersonDo -> {
          responsiblePersonDoRepository.deletePerson(personIdD);
          return true;
      }).orElse(false);
    }

    public ResponsiblePersonDo updatePerson(String personIdD, ResponsiblePersonDo responsiblePersonDoNew) {
        Optional<List<ResponsiblePersonDo>> responsiblePersonDoOptional = getBypersonIdD(personIdD);
        if (responsiblePersonDoOptional.isPresent()) {
            ResponsiblePersonDo responsiblePersonDoExist = responsiblePersonDoOptional.get().get(0);

            if (responsiblePersonDoNew.getPersonNameD() != null) {
                responsiblePersonDoExist.setPersonNameD(responsiblePersonDoNew.getPersonNameD());
            }
            if (responsiblePersonDoNew.getPersonDepartmentD() != null) {
                responsiblePersonDoExist.setPersonDepartmentD(responsiblePersonDoNew.getPersonDepartmentD());
            }
            return savePerson(responsiblePersonDoExist);
        } else {
            throw new EntityNotFoundException("Person with id " + personIdD + " not found");
        }
    }

}
