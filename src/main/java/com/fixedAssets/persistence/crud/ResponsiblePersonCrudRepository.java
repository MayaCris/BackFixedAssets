package com.fixedAssets.persistence.crud;

import com.fixedAssets.persistence.entity.ResponsiblePerson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ResponsiblePersonCrudRepository extends CrudRepository<ResponsiblePerson, String> {

    Optional<List<ResponsiblePerson>> findByPersonId(String personId);

}
