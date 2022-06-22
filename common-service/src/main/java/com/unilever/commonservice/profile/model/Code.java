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
@Table(name = "CODE")
@AttributeOverride(name = "id", column = @Column(name = "CODE_ID"))
public class Code extends AbstractEntity {

    @Column( name = "CODE_TYPE_ID")
    private Long codeTypeId;

    @Column( name = "CODE_VALUE")
    private String codeValue;

    @Column( name = "DESCRIPTION")
    private String description;


}
