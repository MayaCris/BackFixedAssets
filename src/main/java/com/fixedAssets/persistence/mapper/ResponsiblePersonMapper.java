package com.fixedAssets.persistence.mapper;

import com.fixedAssets.domain.ResponsiblePersonDo;
import com.fixedAssets.persistence.entity.ResponsiblePerson;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResponsiblePersonMapper {

    @Mappings({
            @Mapping(source = "personId", target = "personIdD"),
            @Mapping(source = "personName", target = "personNameD"),
            @Mapping(source = "personDepartment", target = "personDepartmentD"),

    })
    ResponsiblePersonDo toResponsiblePersonDo (ResponsiblePerson responsiblePerson);
    List<ResponsiblePersonDo> toResponsiblePersonDoList (List<ResponsiblePerson> responsiblePersonList);

    @InheritInverseConfiguration
    @Mapping(target = "fixedAssets", ignore = true)
    ResponsiblePerson toResponsiblePerson (ResponsiblePersonDo responsiblePersonDo);

}
