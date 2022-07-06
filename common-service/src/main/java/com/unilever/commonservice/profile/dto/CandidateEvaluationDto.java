package com.unilever.commonservice.profile.dto;

import com.unilever.utilityservice.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@Data
@EqualsAndHashCode( callSuper = false)
public class CandidateEvaluationDto extends BaseDto {

    private Long candidateId;
    private Long roleId;
    private Long personalMasteryId;
    private Long agilityId;
    private Long passionForHighPerformanceId;
    private Long strongDriveId;
    private Long strategicMindsetId;
    private Long technicalExpertiseId;
    private Long diversityOfGenderId;
    private String personalMastery;
    private String agility;
    private String passionForHighPerformance;
    private String strongDrive;
    private String strategicMindset;
    private String technicalExpertise;
    private String diversityOfGender;
    private String generalEvaluationComments;
    private Long finalDecisionId;
    private Boolean isOtherRoles;
    private String finalDecision;
    private String otherRolesRecommended;
    private Long readinessTime;
}
