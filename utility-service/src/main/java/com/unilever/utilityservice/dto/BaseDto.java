package com.unilever.utilityservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    Long id;
    Date createdDate;
    String createdBy;
    Date modifiedDate;
    String modifiedBy;
    Boolean active;

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return Boolean.TRUE;
        if (obj == null)
            return Boolean.FALSE;
        if (obj instanceof BaseDto) {
            BaseDto other = (BaseDto) obj;
            return getId().equals(other.getId());
        } else {
            return Boolean.FALSE;
        }

    }

}
