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
@Table(name = "CANDIDATES")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class Candidate extends AbstractEntity {

    @Column(name = "CANDIDATE_NAME")
    private String candidateName;

    @Column( name = "CURRENT_EMPLOYER")
    private String employerName;

    @Column( name = "CURRENT_DESIGNATION")
    private String currentDesignation;

    @Column( name = "ROLE_ID")
    private Long roleId;

    @Column( name = "PROFILE_URL")
    private String profileUrl;

    @Column( name = "EXPERIENCE")
    private Long experience;

    @Column( name = "IS_UNILEVER_BEFORE")
    private Boolean isUnileverBefore;

    @Column( name = "GENDER_ID")
    private Long genderId;

    @Column( name = "IS_SOURCED_BY_HEAD_HUNTER")
    private Boolean isSourcedByHeadHunter;

    @Column( name = "COMMENTS")
    private String comments;

    @Column( name = "HIRING_STATUS_ID")
    private Long hiringStatusId;

    @Column( name = "HAS_INTERVIEWED")
    private Boolean isInterviewed;
}
