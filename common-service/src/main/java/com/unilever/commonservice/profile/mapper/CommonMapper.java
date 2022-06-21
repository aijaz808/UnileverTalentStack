package com.unilever.commonservice.profile.mapper;

import com.unilever.commonservice.profile.dto.ProfileDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.model.Role;
import com.unilever.utilityservice.mapper.BaseMapper;
import org.mapstruct.*;

@Mapper(componentModel = "spring",uses= {BaseMapper.class})
public interface CommonMapper {

    Profile convert(ProfileDto dto);
    ProfileDto convert(Profile entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Role convert(RoleDto roleDto,@MappingTarget Role role);

    RoleDto convert(Role role);
}
