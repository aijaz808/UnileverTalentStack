package com.unilever.utilityservice.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    private ResponseHandler() {
        // Private Constructor
    }

    public static ResponseEntity<?> buildResponseData(Object data) {
        ResponseData response = ResponseData.createInstance(data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<?> buildResponseData(Object data, HttpStatus status) {
        ResponseData response = ResponseData.createInstance(data, HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<?> buildResponseData(Object data, long totalCount, HttpStatus status) {
        ResponseData response = ResponseData.createInstance(data, totalCount);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
