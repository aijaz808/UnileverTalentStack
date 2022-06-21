package com.unilever.utilityservice.mapper;

import com.unilever.utilityservice.dto.BaseDto;
import com.unilever.utilityservice.model.AbstractEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface BaseMapper {
    // Not intended to be generated, but to carry inheritable mapping
    // annotations:
    @Mappings({ @Mapping(source = "active", target = "active", ignore = true),
            @Mapping(source = "createdDate", target = "createdDate", ignore = true),
            @Mapping(source = "createdBy", target = "createdBy", ignore = true),
            @Mapping(source = "modifiedDate", target = "modifiedDate", ignore = true),
            @Mapping(source = "modifiedBy", target = "modifiedBy", ignore = true) })
    AbstractEntity convert(BaseDto dto);

    // Not intended to be generated, but to carry inheritable mapping
    // annotations:
    @Mappings({ @Mapping(source = "active", target = "active", ignore = true),
            @Mapping(source = "createdDate", target = "createdDate", ignore = true),
            @Mapping(source = "createdBy", target = "createdBy", ignore = true),
            @Mapping(source = "modifiedDate", target = "modifiedDate", ignore = true),
            @Mapping(source = "modifiedBy", target = "modifiedBy", ignore = true) })
    BaseDto convert(AbstractEntity entity);
}
