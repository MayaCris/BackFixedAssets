package com.fixedAssets.domain.repository;

import com.fixedAssets.domain.ResponsiblePersonDo;

import java.util.List;
import java.util.Optional;

public interface ResponsiblePersonDoRepository {

    List<ResponsiblePersonDo> getAll();
    Optional<List<ResponsiblePersonDo>> getBypersonIdD(String personIdD);
    ResponsiblePersonDo savePerson(ResponsiblePersonDo responsiblePersonDo);
    void deletePerson(String personIdD);

}
