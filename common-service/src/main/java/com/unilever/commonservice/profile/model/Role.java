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
@Table(name = "ROLE_TYPE")
@AttributeOverride(name = "id", column = @Column(name = "ID"))
public class Role extends AbstractEntity {

    @Column( name = "ROLE_NAME")
    private String roleName;

    @Column( name = "GRADE")
    private String grade;

    @Column( name = "LINE_MANAGER")
    private String lineManager;

    @Column( name = "USER_NAME")
    private String userName;

}
