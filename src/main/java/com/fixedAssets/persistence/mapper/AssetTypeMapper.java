package com.fixedAssets.persistence.mapper;

import com.fixedAssets.domain.AssetTypeDo;
import com.fixedAssets.persistence.entity.AssetType;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetTypeMapper {

    @Mappings({
            @Mapping(source = "typeId", target = "typeIdD"),
            @Mapping(source = "typeName", target = "typeNameD"),
            @Mapping(source = "depreciationTime", target = "depreciationTimeD"),

    })
    AssetTypeDo toAssetTypeDo (AssetType assetType);
    List<AssetTypeDo> toAssetTypeDoList (List<AssetType> assetTypes);

    @InheritInverseConfiguration
    @Mapping(target = "fixedAssets", ignore = true)
    AssetType toAssetType (AssetTypeDo assetTypeDo);


}
