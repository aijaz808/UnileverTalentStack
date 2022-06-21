package com.unilever.commonservice.profile.dto;

import com.unilever.commonservice.profile.constants.RoleType;
import com.unilever.utilityservice.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@Data
@EqualsAndHashCode( callSuper = false)
public class ProfileDto extends BaseDto {

    private String userName;

    private String password;

    private RoleType roleType;
}
