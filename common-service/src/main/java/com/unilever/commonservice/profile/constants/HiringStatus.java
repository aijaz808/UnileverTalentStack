package com.unilever.commonservice.profile.constants;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum HiringStatus {

    AWAITING_CANDIDATE_STATUS(20010, "AWAITING_CANDIDATE_STATUS"),
    CANDIDATE_DECLINED(20012, "CANDIDATE_DECLINED"),
    SHORTLISTED(20013, "SHORTLISTED"),
    HIRED(20011, "HIRED"),
    PROSPECT(20015, "PROSPECT"),
    REJECTED(20016, "REJECTED");

    private final Integer statusCode;
    private final String desc;

    private static final Map<String, HiringStatus> lookup=new HashMap<>();

    HiringStatus(Integer statusCode, String desc) {
        this.statusCode = statusCode;
        this.desc = desc;
    }
    
    public static final Integer get(String string){

      HiringStatus hiringStatus= lookup.get(string);

      Integer status= hiringStatus.getStatusCode();
      return status;
    }
}
