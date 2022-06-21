package com.unilever.commonservice.profile.mapper;

import com.unilever.commonservice.profile.dto.ProfileDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-22T00:58:14+0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CommonMapperImpl implements CommonMapper {

    @Override
    public Profile convert(ProfileDto dto) {
        if ( dto == null ) {
            return null;
        }

        Profile profile = new Profile();

        profile.setId( dto.getId() );
        profile.setCreatedDate( dto.getCreatedDate() );
        profile.setCreatedBy( dto.getCreatedBy() );
        profile.setModifiedDate( dto.getModifiedDate() );
        profile.setModifiedBy( dto.getModifiedBy() );
        profile.setActive( dto.getActive() );
        profile.setUserName( dto.getUserName() );
        profile.setPassword( dto.getPassword() );
        profile.setRoleType( dto.getRoleType() );

        return profile;
    }

    @Override
    public ProfileDto convert(Profile entity) {
        if ( entity == null ) {
            return null;
        }

        ProfileDto profileDto = new ProfileDto();

        profileDto.setId( entity.getId() );
        profileDto.setCreatedDate( entity.getCreatedDate() );
        profileDto.setCreatedBy( entity.getCreatedBy() );
        profileDto.setModifiedDate( entity.getModifiedDate() );
        profileDto.setModifiedBy( entity.getModifiedBy() );
        profileDto.setActive( entity.getActive() );
        profileDto.setUserName( entity.getUserName() );
        profileDto.setPassword( entity.getPassword() );
        profileDto.setRoleType( entity.getRoleType() );

        return profileDto;
    }

    @Override
    public Role convert(RoleDto roleDto, Role role) {
        if ( roleDto == null ) {
            return null;
        }

        if ( roleDto.getId() != null ) {
            role.setId( roleDto.getId() );
        }
        if ( roleDto.getCreatedDate() != null ) {
            role.setCreatedDate( roleDto.getCreatedDate() );
        }
        if ( roleDto.getCreatedBy() != null ) {
            role.setCreatedBy( roleDto.getCreatedBy() );
        }
        if ( roleDto.getModifiedDate() != null ) {
            role.setModifiedDate( roleDto.getModifiedDate() );
        }
        if ( roleDto.getModifiedBy() != null ) {
            role.setModifiedBy( roleDto.getModifiedBy() );
        }
        if ( roleDto.getActive() != null ) {
            role.setActive( roleDto.getActive() );
        }
        if ( roleDto.getRoleName() != null ) {
            role.setRoleName( roleDto.getRoleName() );
        }
        if ( roleDto.getGrade() != null ) {
            role.setGrade( roleDto.getGrade() );
        }
        if ( roleDto.getLineManager() != null ) {
            role.setLineManager( roleDto.getLineManager() );
        }

        return role;
    }

    @Override
    public RoleDto convert(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setCreatedDate( role.getCreatedDate() );
        roleDto.setCreatedBy( role.getCreatedBy() );
        roleDto.setModifiedDate( role.getModifiedDate() );
        roleDto.setModifiedBy( role.getModifiedBy() );
        roleDto.setActive( role.getActive() );
        roleDto.setRoleName( role.getRoleName() );
        roleDto.setGrade( role.getGrade() );
        roleDto.setLineManager( role.getLineManager() );

        return roleDto;
    }
}
