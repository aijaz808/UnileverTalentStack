package com.unilever.commonservice.profile.dto;

import com.unilever.utilityservice.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;

@Data
@EqualsAndHashCode( callSuper = false)
public class RoleDto extends BaseDto {


    private String roleName;

    private String grade;

    private String lineManager;

}
