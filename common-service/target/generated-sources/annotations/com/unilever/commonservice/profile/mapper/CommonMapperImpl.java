package com.unilever.commonservice.profile.mapper;

import com.unilever.commonservice.profile.dto.CandidateDto;
import com.unilever.commonservice.profile.dto.CandidateEvaluationDto;
import com.unilever.commonservice.profile.dto.ProfileDto;
import com.unilever.commonservice.profile.dto.RoleDto;
import com.unilever.commonservice.profile.model.Candidate;
import com.unilever.commonservice.profile.model.CandidateEvaluation;
import com.unilever.commonservice.profile.model.Profile;
import com.unilever.commonservice.profile.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-29T01:59:26+0500",
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
        if ( roleDto.getUserName() != null ) {
            role.setUserName( roleDto.getUserName() );
        }

        return role;
    }

    @Override
    public RoleDto convert(Role role) {
        if ( role == null ) {
            return null;
        }

        String roleName = null;
        String grade = null;
        String lineManager = null;
        String userName = null;

        roleName = role.getRoleName();
        grade = role.getGrade();
        lineManager = role.getLineManager();
        userName = role.getUserName();

        RoleDto roleDto = new RoleDto( roleName, grade, lineManager, userName );

        roleDto.setId( role.getId() );
        roleDto.setCreatedDate( role.getCreatedDate() );
        roleDto.setCreatedBy( role.getCreatedBy() );
        roleDto.setModifiedDate( role.getModifiedDate() );
        roleDto.setModifiedBy( role.getModifiedBy() );
        roleDto.setActive( role.getActive() );

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

    @Override
    public CandidateEvaluation convert(CandidateEvaluationDto candidateEvaluationDto, CandidateEvaluation candidate) {
        if ( candidateEvaluationDto == null ) {
            return null;
        }

        if ( candidateEvaluationDto.getId() != null ) {
            candidate.setId( candidateEvaluationDto.getId() );
        }
        if ( candidateEvaluationDto.getCreatedDate() != null ) {
            candidate.setCreatedDate( candidateEvaluationDto.getCreatedDate() );
        }
        if ( candidateEvaluationDto.getCreatedBy() != null ) {
            candidate.setCreatedBy( candidateEvaluationDto.getCreatedBy() );
        }
        if ( candidateEvaluationDto.getModifiedDate() != null ) {
            candidate.setModifiedDate( candidateEvaluationDto.getModifiedDate() );
        }
        if ( candidateEvaluationDto.getModifiedBy() != null ) {
            candidate.setModifiedBy( candidateEvaluationDto.getModifiedBy() );
        }
        if ( candidateEvaluationDto.getActive() != null ) {
            candidate.setActive( candidateEvaluationDto.getActive() );
        }
        if ( candidateEvaluationDto.getCandidateId() != null ) {
            candidate.setCandidateId( candidateEvaluationDto.getCandidateId() );
        }
        if ( candidateEvaluationDto.getPersonalMasteryId() != null ) {
            candidate.setPersonalMasteryId( candidateEvaluationDto.getPersonalMasteryId() );
        }
        if ( candidateEvaluationDto.getAgilityId() != null ) {
            candidate.setAgilityId( candidateEvaluationDto.getAgilityId() );
        }
        if ( candidateEvaluationDto.getPassionForHighPerformanceId() != null ) {
            candidate.setPassionForHighPerformanceId( candidateEvaluationDto.getPassionForHighPerformanceId() );
        }
        if ( candidateEvaluationDto.getStrongDriveId() != null ) {
            candidate.setStrongDriveId( candidateEvaluationDto.getStrongDriveId() );
        }
        if ( candidateEvaluationDto.getStrategicMindsetId() != null ) {
            candidate.setStrategicMindsetId( candidateEvaluationDto.getStrategicMindsetId() );
        }
        if ( candidateEvaluationDto.getTechnicalExpertiseId() != null ) {
            candidate.setTechnicalExpertiseId( candidateEvaluationDto.getTechnicalExpertiseId() );
        }
        if ( candidateEvaluationDto.getDiversityOfGenderId() != null ) {
            candidate.setDiversityOfGenderId( candidateEvaluationDto.getDiversityOfGenderId() );
        }
        if ( candidateEvaluationDto.getGeneralEvaluationComments() != null ) {
            candidate.setGeneralEvaluationComments( candidateEvaluationDto.getGeneralEvaluationComments() );
        }
        if ( candidateEvaluationDto.getFinalDecisionId() != null ) {
            candidate.setFinalDecisionId( candidateEvaluationDto.getFinalDecisionId() );
        }
        if ( candidateEvaluationDto.getIsOtherRoles() != null ) {
            candidate.setIsOtherRoles( candidateEvaluationDto.getIsOtherRoles() );
        }
        if ( candidateEvaluationDto.getOtherRolesRecommended() != null ) {
            candidate.setOtherRolesRecommended( candidateEvaluationDto.getOtherRolesRecommended() );
        }
        if ( candidateEvaluationDto.getReadinessTime() != null ) {
            candidate.setReadinessTime( candidateEvaluationDto.getReadinessTime() );
        }

        return candidate;
    }

    @Override
    public CandidateEvaluationDto convert(CandidateEvaluation candidateEvaluation) {
        if ( candidateEvaluation == null ) {
            return null;
        }

        CandidateEvaluationDto candidateEvaluationDto = new CandidateEvaluationDto();

        candidateEvaluationDto.setId( candidateEvaluation.getId() );
        candidateEvaluationDto.setCreatedDate( candidateEvaluation.getCreatedDate() );
        candidateEvaluationDto.setCreatedBy( candidateEvaluation.getCreatedBy() );
        candidateEvaluationDto.setModifiedDate( candidateEvaluation.getModifiedDate() );
        candidateEvaluationDto.setModifiedBy( candidateEvaluation.getModifiedBy() );
        candidateEvaluationDto.setActive( candidateEvaluation.getActive() );
        candidateEvaluationDto.setCandidateId( candidateEvaluation.getCandidateId() );
        candidateEvaluationDto.setPersonalMasteryId( candidateEvaluation.getPersonalMasteryId() );
        candidateEvaluationDto.setAgilityId( candidateEvaluation.getAgilityId() );
        candidateEvaluationDto.setPassionForHighPerformanceId( candidateEvaluation.getPassionForHighPerformanceId() );
        candidateEvaluationDto.setStrongDriveId( candidateEvaluation.getStrongDriveId() );
        candidateEvaluationDto.setStrategicMindsetId( candidateEvaluation.getStrategicMindsetId() );
        candidateEvaluationDto.setTechnicalExpertiseId( candidateEvaluation.getTechnicalExpertiseId() );
        candidateEvaluationDto.setDiversityOfGenderId( candidateEvaluation.getDiversityOfGenderId() );
        candidateEvaluationDto.setGeneralEvaluationComments( candidateEvaluation.getGeneralEvaluationComments() );
        candidateEvaluationDto.setFinalDecisionId( candidateEvaluation.getFinalDecisionId() );
        candidateEvaluationDto.setIsOtherRoles( candidateEvaluation.getIsOtherRoles() );
        candidateEvaluationDto.setOtherRolesRecommended( candidateEvaluation.getOtherRolesRecommended() );
        candidateEvaluationDto.setReadinessTime( candidateEvaluation.getReadinessTime() );

        return candidateEvaluationDto;
    }
}
