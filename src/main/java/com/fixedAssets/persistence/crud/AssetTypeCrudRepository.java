package com.fixedAssets.persistence.crud;

import com.fixedAssets.persistence.entity.AssetType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


//extends CrudRepository <Clase que va a gestionar, Tipo de dato de la primary key>
public interface AssetTypeCrudRepository extends CrudRepository<AssetType, Integer> {


}
