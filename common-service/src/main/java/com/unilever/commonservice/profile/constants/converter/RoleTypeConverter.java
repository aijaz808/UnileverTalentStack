package com.unilever.commonservice.profile.constants.converter;

import com.unilever.commonservice.profile.constants.RoleType;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Objects;

public class RoleTypeConverter implements AttributeConverter<RoleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(RoleType roleType) {
        if (roleType == null) return null;
        return Arrays.stream(RoleType.values()).filter(e -> Objects.equals(e.getStatusCode(), roleType.getStatusCode())).map(RoleType::getStatusCode).findFirst().orElse(null);
    }

    @Override
    public RoleType convertToEntityAttribute(Integer roleType) {
        if (roleType == null) return null;
        return Arrays.stream(RoleType.values()).filter(e -> Objects.equals(e.getStatusCode(), roleType)).findFirst().orElse(null);
    }
}
