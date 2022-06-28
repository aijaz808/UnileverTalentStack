package com.unilever.commonservice.profile.dto;

import com.unilever.utilityservice.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.With;

import javax.persistence.Column;

@Data
@With
@AllArgsConstructor
@EqualsAndHashCode( callSuper = false)
public class RoleDto extends BaseDto {


    private String roleName;

    private String grade;

    private String lineManager;

    private String userName;

}
