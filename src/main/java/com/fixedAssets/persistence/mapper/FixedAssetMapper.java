package com.fixedAssets.persistence.mapper;

import com.fixedAssets.domain.FixedAssetDo;
import com.fixedAssets.persistence.entity.FixedAsset;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ResponsiblePersonMapper.class, LocationMapper.class, AssetTypeMapper.class})
public interface FixedAssetMapper {
    @Mappings({
            @Mapping(source = "assetId", target = "assetIdD"),
            @Mapping(source = "assetCode", target = "assetCodeD"),
            @Mapping(source = "assetName", target = "assetNameD"),
            @Mapping(source = "assetDescription", target = "assetDescriptionD"),
            @Mapping(source = "typeId", target = "typeIdD"),
            @Mapping(source = "acquisitionDate", target = "acquisitionDateD"),
            @Mapping(source = "acquisitionValue", target = "acquisitionValueD"),
            @Mapping(source = "locationId", target = "locationIdD"),
            @Mapping(source = "personId", target = "personIdD"),
            @Mapping(source = "responsiblePerson", target = "responsiblePersonDo"),
            @Mapping(source = "assetType", target = "assetTypeDo"),
            @Mapping(source = "location", target = "locationDo")
    })
    FixedAssetDo toFixedAssetDo (FixedAsset fixedAsset);
    List<FixedAssetDo> toFixedAssetDoList (List<FixedAsset> fixedAssets);

    @InheritInverseConfiguration
    @Mapping(target = "depreciations", ignore = true)
    FixedAsset toFixedAsset (FixedAssetDo fixedAssetDo);
}
