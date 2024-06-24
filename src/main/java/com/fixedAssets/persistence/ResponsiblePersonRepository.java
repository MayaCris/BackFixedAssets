package com.fixedAssets.persistence;

import com.fixedAssets.domain.ResponsiblePersonDo;
import com.fixedAssets.domain.repository.ResponsiblePersonDoRepository;
import com.fixedAssets.persistence.crud.ResponsiblePersonCrudRepository;
import com.fixedAssets.persistence.entity.ResponsiblePerson;
import com.fixedAssets.persistence.mapper.ResponsiblePersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ResponsiblePersonRepository implements ResponsiblePersonDoRepository {

    @Autowired
    ResponsiblePersonCrudRepository responsiblePersonCrudRepository;

    @Autowired
    private ResponsiblePersonMapper mapper;

    @Override
    public List<ResponsiblePersonDo> getAll() {
        return mapper.toResponsiblePersonDoList((List<ResponsiblePerson>) responsiblePersonCrudRepository.findAll());
    }

    @Override
    public Optional<List<ResponsiblePersonDo>> getBypersonIdD(String personId) {
        return responsiblePersonCrudRepository.findByPersonId(personId).map(responsiblePersons -> mapper.toResponsiblePersonDoList(responsiblePersons));
    }

    @Override
    public ResponsiblePersonDo savePerson(ResponsiblePersonDo responsiblePersonDo) {
        ResponsiblePerson responsiblePerson = mapper.toResponsiblePerson(responsiblePersonDo);
        return mapper.toResponsiblePersonDo(responsiblePersonCrudRepository.save(responsiblePerson));
    }

    @Override
    public void deletePerson(String personIdD) {
        responsiblePersonCrudRepository.deleteById(personIdD);
    }
}
