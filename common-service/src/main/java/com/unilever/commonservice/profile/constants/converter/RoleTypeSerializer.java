package com.unilever.commonservice.profile.constants.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.unilever.commonservice.profile.constants.RoleType;

import java.io.IOException;

public class RoleTypeSerializer extends JsonSerializer<RoleType> {

    @Override
    public void serialize(RoleType value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getStatusCode());
    }
}