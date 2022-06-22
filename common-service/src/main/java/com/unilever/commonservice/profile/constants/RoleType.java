package com.unilever.commonservice.profile.constants;

import lombok.Getter;

@Getter
public enum RoleType {

    TALENT_EXPERT( 20191),
    EVALUATOR( 21092);

    private final Integer statusCode;

    RoleType(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
