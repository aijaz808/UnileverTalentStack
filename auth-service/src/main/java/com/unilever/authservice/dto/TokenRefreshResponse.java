package com.unilever.authservice.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class TokenRefreshResponse {

    private ObjectNode refreshToken;

    public TokenRefreshResponse(ObjectNode refreshToken) {
        this.refreshToken = refreshToken;

    }
}