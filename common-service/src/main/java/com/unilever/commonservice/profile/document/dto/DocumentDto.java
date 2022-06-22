package com.unilever.commonservice.profile.document.dto;

import com.unilever.utilityservice.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode( callSuper = false)
public class DocumentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String fileName;
    private String processAcronym;
    private Long candidateId;
    private String subDirectory;
    private String base64;
    private String documentType;

}
