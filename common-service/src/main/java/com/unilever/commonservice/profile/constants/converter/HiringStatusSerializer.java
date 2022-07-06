package com.unilever.commonservice.profile.constants.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.unilever.commonservice.profile.constants.HiringStatus;


import java.io.IOException;

public class HiringStatusSerializer extends JsonSerializer<HiringStatus> {

    @Override
    public void serialize(HiringStatus value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getStatusCode());
    }
}
