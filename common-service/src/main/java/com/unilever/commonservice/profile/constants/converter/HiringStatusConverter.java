package com.unilever.commonservice.profile.constants.converter;

import com.unilever.commonservice.profile.constants.HiringStatus;
import com.unilever.commonservice.profile.constants.RoleType;

import javax.persistence.AttributeConverter;
import java.util.Arrays;
import java.util.Objects;

public class HiringStatusConverter implements AttributeConverter<HiringStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(HiringStatus hiringStatus) {
        if (hiringStatus == null) return null;
        return Arrays.stream(HiringStatus.values()).filter(e -> Objects.equals(e.getStatusCode(), hiringStatus.getStatusCode())).map(HiringStatus::getStatusCode).findFirst().orElse(null);
    }

    @Override
    public HiringStatus convertToEntityAttribute(Integer hiringStatus) {
        if (hiringStatus == null) return null;
        return Arrays.stream(HiringStatus.values()).filter(e -> Objects.equals(e.getStatusCode(), hiringStatus)).findFirst().orElse(null);
    }
}
