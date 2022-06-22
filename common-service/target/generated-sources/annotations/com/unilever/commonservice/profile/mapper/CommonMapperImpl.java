package com.unilever.commonservice.profile.mapper;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.ProfileDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-23T00:40:35+0500",
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

    @Override
    public Candidate convert(CandidateDto candidateDto, Candidate candidate) {
        if ( candidateDto == null ) {
            return null;
        }

        if ( candidateDto.getId() != null ) {
            candidate.setId( candidateDto.getId() );
        }
        if ( candidateDto.getCreatedDate() != null ) {
            candidate.setCreatedDate( candidateDto.getCreatedDate() );
        }
        if ( candidateDto.getCreatedBy() != null ) {
            candidate.setCreatedBy( candidateDto.getCreatedBy() );
        }
        if ( candidateDto.getModifiedDate() != null ) {
            candidate.setModifiedDate( candidateDto.getModifiedDate() );
        }
        if ( candidateDto.getModifiedBy() != null ) {
            candidate.setModifiedBy( candidateDto.getModifiedBy() );
        }
        if ( candidateDto.getActive() != null ) {
            candidate.setActive( candidateDto.getActive() );
        }
        if ( candidateDto.getCandidateName() != null ) {
            candidate.setCandidateName( candidateDto.getCandidateName() );
        }
        if ( candidateDto.getEmployerName() != null ) {
            candidate.setEmployerName( candidateDto.getEmployerName() );
        }
        if ( candidateDto.getCurrentDesignation() != null ) {
            candidate.setCurrentDesignation( candidateDto.getCurrentDesignation() );
        }
        if ( candidateDto.getRoleId() != null ) {
            candidate.setRoleId( candidateDto.getRoleId() );
        }
        if ( candidateDto.getProfileUrl() != null ) {
            candidate.setProfileUrl( candidateDto.getProfileUrl() );
        }
        if ( candidateDto.getExperience() != null ) {
            candidate.setExperience( candidateDto.getExperience() );
        }
        if ( candidateDto.getIsUnileverBefore() != null ) {
            candidate.setIsUnileverBefore( candidateDto.getIsUnileverBefore() );
        }
        if ( candidateDto.getGenderId() != null ) {
            candidate.setGenderId( candidateDto.getGenderId() );
        }
        if ( candidateDto.getIsSourcedByHeadHunter() != null ) {
            candidate.setIsSourcedByHeadHunter( candidateDto.getIsSourcedByHeadHunter() );
        }
        if ( candidateDto.getComments() != null ) {
            candidate.setComments( candidateDto.getComments() );
        }
        if ( candidateDto.getHiringStatusId() != null ) {
            candidate.setHiringStatusId( candidateDto.getHiringStatusId() );
        }
        if ( candidateDto.getIsInterviewed() != null ) {
            candidate.setIsInterviewed( candidateDto.getIsInterviewed() );
        }

        return candidate;
    }

    @Override
    public CandidateDto convert(Candidate candidate) {
        if ( candidate == null ) {
            return null;
        }

        CandidateDto candidateDto = new CandidateDto();

        candidateDto.setId( candidate.getId() );
        candidateDto.setCreatedDate( candidate.getCreatedDate() );
        candidateDto.setCreatedBy( candidate.getCreatedBy() );
        candidateDto.setModifiedDate( candidate.getModifiedDate() );
        candidateDto.setModifiedBy( candidate.getModifiedBy() );
        candidateDto.setActive( candidate.getActive() );
        candidateDto.setCandidateName( candidate.getCandidateName() );
        candidateDto.setEmployerName( candidate.getEmployerName() );
        candidateDto.setCurrentDesignation( candidate.getCurrentDesignation() );
        candidateDto.setRoleId( candidate.getRoleId() );
        candidateDto.setProfileUrl( candidate.getProfileUrl() );
        candidateDto.setExperience( candidate.getExperience() );
        candidateDto.setIsUnileverBefore( candidate.getIsUnileverBefore() );
        candidateDto.setGenderId( candidate.getGenderId() );
        candidateDto.setIsSourcedByHeadHunter( candidate.getIsSourcedByHeadHunter() );
        candidateDto.setComments( candidate.getComments() );
        candidateDto.setHiringStatusId( candidate.getHiringStatusId() );
        candidateDto.setIsInterviewed( candidate.getIsInterviewed() );

        return candidateDto;
    }
}
