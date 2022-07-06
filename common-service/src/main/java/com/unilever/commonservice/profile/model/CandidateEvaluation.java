package com.unilever.commonservice.profile.model;

import com.unilever.utilityservice.model.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CANDIDATE_EVALUATION")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class CandidateEvaluation extends AbstractEntity {

    @Column( name = "CANDIDATE_ID")
    private Long candidateId;

    @Column( name = "ROLE_ID")
    private Long roleId;

    @Column( name = "PERSONAL_MASTERY")
    private Long personalMasteryId;

    @Column( name = "AGILITY")
    private Long agilityId;

    @Column( name = "PASSION_FOR_HIGH_PERFORMANCE")
    private Long passionForHighPerformanceId;

    @Column( name = "STRONG_DRIVE")
    private Long strongDriveId;

    @Column( name = "STRATEGIC_MINDSET")
    private Long strategicMindsetId;

    @Column( name = "TECHNICAL_EXPERTISE")
    private Long technicalExpertiseId;

    @Column( name = "DIVERSITY_OF_GENDER")
    private Long diversityOfGenderId;

    @Column( name = "GENERAL_EVALUATION_COMMENTS")
    private String generalEvaluationComments;

    @Column( name = "FINAL_DECISION")
    private Long finalDecisionId;

    @Column( name = "IS_RECOMMENDED_FOR_OTHER_ROLES")
    private Boolean isOtherRoles;

    @Column( name = "OTHER_ROLES_RECOMMENDED")
    private String otherRolesRecommended;

    @Column( name = "READINESS_TIME")
    private Long readinessTime;
}
