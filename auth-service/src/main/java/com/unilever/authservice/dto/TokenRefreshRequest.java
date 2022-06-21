package com.unilever.authservice.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

@Data
@EqualsAndHashCode(callSuper=false)
public class TokenRefreshRequest {

    @NotBlank
    private String refreshToken;
}