package com.unilever.commonservice.profile.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.unilever.commonservice.profile.constants.RoleType;
import com.unilever.commonservice.profile.constants.converter.RoleTypeConverter;
import com.unilever.commonservice.profile.constants.converter.RoleTypeSerializer;
import com.unilever.utilityservice.model.AbstractEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "COMMON_PROFILE")
@AttributeOverride(name = "id", column = @Column(name = "COMMON_PROFILE_ID"))
public class Profile extends AbstractEntity {


    @Column( name = "USER_NAME")
    private String userName;

    @Column( name = "PASSWORD")
    private String password;

    @Column( name = "ROLE")
    @Convert(converter = RoleTypeConverter.class)
    @JsonSerialize(using = RoleTypeSerializer.class)
    private RoleType roleType;
}
