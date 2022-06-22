package com.unilever.commonservice.profile.dto;

import com.unilever.utilityservice.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@Data
@EqualsAndHashCode( callSuper = false)
public class CandidateDto extends BaseDto {


    private String candidateName;

    private String employerName;

    private String currentDesignation;

    private Long roleId;

    private String role;

    private String profileUrl;

    private Long experience;

    private Boolean isUnileverBefore;

    private Long genderId;

    private String gender;

    private Boolean isSourcedByHeadHunter;

    private String comments;

    private Long hiringStatusId;

    private String hiringStatus;

    private Boolean isInterviewed;
}
